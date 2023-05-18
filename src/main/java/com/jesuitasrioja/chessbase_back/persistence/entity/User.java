package com.jesuitasrioja.chessbase_back.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Language language;

    public User(String email, String username, String password, String name) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", exercises=" + exercises +
                ", roles=" + roles +
                ", team=" + team +
                ", language=" + language +
                '}';
    }
}
