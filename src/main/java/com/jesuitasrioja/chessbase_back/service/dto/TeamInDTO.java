package com.jesuitasrioja.chessbase_back.service.dto;

import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import lombok.Data;

@Data
public class TeamInDTO {
    private String name;
    private int numberOfParticipants;
}
