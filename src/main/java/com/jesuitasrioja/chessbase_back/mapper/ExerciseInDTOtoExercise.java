package com.jesuitasrioja.chessbase_back.mapper;

import com.jesuitasrioja.chessbase_back.persistence.entity.Exercise;
import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import com.jesuitasrioja.chessbase_back.service.dto.ExerciseInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExerciseInDTOtoExercise implements IMapper<ExerciseInDTO, Exercise> {


    @Override
    public Exercise map(ExerciseInDTO in) {
        Exercise exercise = new Exercise();

        exercise.setTitle(in.getTitle());
        exercise.setCreator(in.getCreator());
        exercise.setNPlayers(in.getNPlayers());

        return exercise;
    }
}