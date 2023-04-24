package com.jesuitasrioja.chessbase_back.controller;


import com.jesuitasrioja.chessbase_back.persistence.entity.Exercise;
import com.jesuitasrioja.chessbase_back.service.ExerciseService;
import com.jesuitasrioja.chessbase_back.service.dto.ExerciseInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public Exercise createExercise(@RequestBody ExerciseInDTO exerciseInDTO){
        return this.exerciseService.createExercise(exerciseInDTO);
    }

    @GetMapping
    public List<Exercise> findAll(){
        return this.exerciseService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        this.exerciseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
