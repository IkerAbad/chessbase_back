package com.jesuitasrioja.chessbase_back.service.dto;

import lombok.Data;

@Data
public class UserInDTO {
    private String name;
    private String lastname;
    private String email;
    private String username;
    private String password;
}
