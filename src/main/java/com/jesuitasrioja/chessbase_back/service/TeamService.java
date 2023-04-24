package com.jesuitasrioja.chessbase_back.service;

import com.jesuitasrioja.chessbase_back.exceptions.ChessbaseExceptions;
import com.jesuitasrioja.chessbase_back.mapper.TeamInDTOtoTeam;
import com.jesuitasrioja.chessbase_back.persistence.entity.Exercise;
import com.jesuitasrioja.chessbase_back.persistence.entity.Team;
import com.jesuitasrioja.chessbase_back.persistence.repository.TeamRepository;
import com.jesuitasrioja.chessbase_back.service.dto.TeamInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final TeamInDTOtoTeam mapper;

    public TeamService(TeamRepository repository, TeamInDTOtoTeam mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Team createTeam(TeamInDTO teamInDTO){
        Team team = mapper.map(teamInDTO);
        return this.repository.save(team);
    }

    public List<Team> findAll(){
        return this.repository.findAll();
    }

    public void deleteById(Integer id){
        Optional<Team> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ChessbaseExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
