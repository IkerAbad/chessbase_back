package com.jesuitasrioja.chessbase_back.controller;

import com.jesuitasrioja.chessbase_back.persistence.entity.Team;
import com.jesuitasrioja.chessbase_back.service.TeamService;
import com.jesuitasrioja.chessbase_back.service.dto.TeamInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public Team createTeam(@RequestBody TeamInDTO teamInDTO){
        return this.teamService.createTeam(teamInDTO);
    }

    @GetMapping
    public List<Team> findAll(){
        return this.teamService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        this.teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
