package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "manga")
@Data
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int rate;

    private String description;

    private String author;

    private String artAuthor;

    @OneToMany(mappedBy = "manga")
    private List<Tag> tags;

    @OneToMany(mappedBy = "manga")
    private List<Episode> episodes;

    private LocalDate dateOfPublish;

    private String mangaStatus;

    private String type;

    @ManyToMany(mappedBy = "mangas")
    private Set<Genre> genres;

    private String mainImage;
}