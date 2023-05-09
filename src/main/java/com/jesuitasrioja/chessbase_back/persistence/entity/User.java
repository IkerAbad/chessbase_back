package com.jesuitasrioja.chessbase_back.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String username;
    private String password;

    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "exercise_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName
                    = "id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id",
                    referencedColumnName = "id"))
    private List<Exercise> exercises;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Language language;
}
