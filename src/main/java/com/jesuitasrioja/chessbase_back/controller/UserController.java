package com.jesuitasrioja.chessbase_back.controller;

import com.jesuitasrioja.chessbase_back.persistence.entity.Team;
import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.service.TeamService;
import com.jesuitasrioja.chessbase_back.service.UserService;
import com.jesuitasrioja.chessbase_back.service.dto.TeamInDTO;
import com.jesuitasrioja.chessbase_back.service.dto.UserInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody UserInDTO userInDTO){
        return this.userService.createUser(userInDTO);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
