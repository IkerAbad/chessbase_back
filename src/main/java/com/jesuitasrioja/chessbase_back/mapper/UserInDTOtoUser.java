package com.jesuitasrioja.chessbase_back.mapper;

import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.service.dto.UserInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserInDTOtoUser implements IMapper<UserInDTO, User>{

    @Override
    public User map(UserInDTO in) {
        User user = new User();
        user.setUsername(in.getUsername());
        user.setPassword(in.getPassword());
        user.setEmail(in.getEmail());
        user.setFullName(in.getFullName());
        user.setCreatedDate(LocalDateTime.now());
        return user;
    }
}
