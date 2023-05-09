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
        user.setName(in.getName());
        user.setLastname(in.getLastname());
        user.setEmail(in.getEmail());
        user.setUsername(in.getUsername());
        user.setPassword(in.getPassword());

        return user;
    }
}
