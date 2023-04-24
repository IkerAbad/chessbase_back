package com.jesuitasrioja.chessbase_back.persistence.repository;


import com.jesuitasrioja.chessbase_back.persistence.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
