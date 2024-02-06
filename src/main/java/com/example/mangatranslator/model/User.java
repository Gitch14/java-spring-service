package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_manga_read_now",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private Set<Manga> mangaReadNow;

    @ManyToMany
    @JoinTable(
            name = "user_manga_read_soon",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private Set<Manga> mangaReadSoon;

}