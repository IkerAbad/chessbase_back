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
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String title;
    private String creator;
    private String nPlayers;

    @ManyToMany(mappedBy = "exercise")
    private List<User> users;

}
