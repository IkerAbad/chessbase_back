package com.jesuitasrioja.chessbase_back.mapper;

import com.jesuitasrioja.chessbase_back.persistence.entity.Team;
import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.service.dto.TeamInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeamInDTOtoTeam implements IMapper<TeamInDTO, Team>{

    @Override
    public Team map(TeamInDTO in) {
        Team team = new Team();
        team.setName(in.getName());
        team.setNumberOfParticipants(in.getNumberOfParticipants());
        team.setCreatedDate(LocalDateTime.now());

        team.setCreator(new User());

        return team;
    }
}
