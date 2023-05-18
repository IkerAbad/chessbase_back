package com.jesuitasrioja.chessbase_back.persistence.repository;

import com.jesuitasrioja.chessbase_back.persistence.entity.Role;
import com.jesuitasrioja.chessbase_back.persistence.entity.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(RoleUser name);
}