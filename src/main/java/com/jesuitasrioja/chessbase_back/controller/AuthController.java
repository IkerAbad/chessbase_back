package com.jesuitasrioja.chessbase_back.controller;


import com.jesuitasrioja.chessbase_back.payload.request.LoginRequest;
import com.jesuitasrioja.chessbase_back.payload.request.SignupRequest;
import com.jesuitasrioja.chessbase_back.payload.response.JwtResponse;
import com.jesuitasrioja.chessbase_back.payload.response.Response;
import com.jesuitasrioja.chessbase_back.persistence.entity.Role;
import com.jesuitasrioja.chessbase_back.persistence.entity.RoleUser;
import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.persistence.repository.RoleRepository;
import com.jesuitasrioja.chessbase_back.persistence.repository.UserRepository;
import com.jesuitasrioja.chessbase_back.security.jwt.JwtUtils;
import com.jesuitasrioja.chessbase_back.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest
                                                      loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new
                        UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl)
                authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest
                                                  signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(Response.errorResponse(HttpStatus.CONFLICT.value(),"Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(Response.errorResponse(HttpStatus.CONFLICT.value(),"Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(
                signUpRequest.getEmail(),signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()),signUpRequest.getUsername());
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleUser.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole =
                                roleRepository.findByName(RoleUser.ROLE_ADMIN)
                                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    default:
                        Role userRole =
                                roleRepository.findByName(RoleUser.ROLE_USER)
                                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully!",
                HttpStatus.OK);
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("Logout successfully!",
                HttpStatus.OK);
    }

}