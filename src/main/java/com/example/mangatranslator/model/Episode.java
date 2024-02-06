package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "episode")
@Data
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mainImage;

    private int episodeNumber;

    private String episodeName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userWhoAdded;

    private LocalDate dateAdded;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @OneToMany(mappedBy = "episode")
    private Set<Comment> comments;
}

