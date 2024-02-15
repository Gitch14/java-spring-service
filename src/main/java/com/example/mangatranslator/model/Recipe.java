package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String type;
    private String imagePath;
    private String videoPath;
    private String optional;
    private LocalDateTime datePublish;

    @ManyToOne
    private Difficulty difficulty;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeStep> steps = new ArrayList<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "recipe")
    private Set<Comment> comments = new HashSet<>();

    private int likes;
    private int dislikes;
    private int reports;
    private double rating;

    private int calories;
    private int proteins;
    private int carbohydrates;
    private int fats;

    @ManyToOne
    private User author;
}
