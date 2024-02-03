package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorite")
@Data
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;
}