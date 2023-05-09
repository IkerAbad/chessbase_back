package com.jesuitasrioja.chessbase_back.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String nPlayers;
    private String competition;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    private List<User> users;

}
