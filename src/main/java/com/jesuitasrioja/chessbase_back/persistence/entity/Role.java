package com.jesuitasrioja.chessbase_back.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleUser name;
    public Role() {
    }
    public Role(RoleUser name) {
        this.name = name;
    }
}


