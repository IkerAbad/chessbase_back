package com.jesuitasrioja.chessbase_back.persistence.repository;

import com.jesuitasrioja.chessbase_back.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
