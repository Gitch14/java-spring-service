package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "episode")
@Data
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Column(name = "episode_number")
    private int episodeNumber;
}
