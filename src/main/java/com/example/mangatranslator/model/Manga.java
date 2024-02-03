package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "manga")
@Data
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "original_images_path")
    private String originalImagesPath;

    @ManyToOne
    @JoinColumn(name = "list_language_id")
    private Language listLanguage;

    @OneToMany(mappedBy = "manga")
    private List<Episode> episodes;
}