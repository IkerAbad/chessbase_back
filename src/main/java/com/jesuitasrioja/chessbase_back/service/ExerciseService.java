package com.jesuitasrioja.chessbase_back.service;

import com.jesuitasrioja.chessbase_back.exceptions.ChessbaseExceptions;
import com.jesuitasrioja.chessbase_back.mapper.ExerciseInDTOtoExercise;
import com.jesuitasrioja.chessbase_back.persistence.entity.Exercise;
import com.jesuitasrioja.chessbase_back.persistence.repository.ExerciseRepository;
import com.jesuitasrioja.chessbase_back.service.dto.ExerciseInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    private final ExerciseRepository repository;
    private final ExerciseInDTOtoExercise mapper;

    public ExerciseService(ExerciseRepository repository, ExerciseInDTOtoExercise mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Exercise createExercise(ExerciseInDTO exerciseInDTO) {
        Exercise exercise = mapper.map(exerciseInDTO);
        return this.repository.save(exercise);
    }

    public List<Exercise> findAll() {
        return this.repository.findAll();
    }

    public void deleteById(Integer id){
        Optional<Exercise> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ChessbaseExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}