package com.jesuitasrioja.chessbase_back.service.dto;

import lombok.Data;

@Data
public class UserInDTO {
    private String username;
    private String email;
    private String password;
    private String fullName;
}
