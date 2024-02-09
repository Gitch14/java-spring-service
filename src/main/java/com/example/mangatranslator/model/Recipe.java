package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
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
    private String htmlFilePath;
    @ManyToMany
    private Set<Tag> tags = new HashSet<>();
    @OneToMany(mappedBy = "recipe")
    private Set<Comment> comments = new HashSet<>();
    private int likes;
    private int dislikes;
    private int reports;
    @ManyToOne
    private User author;
}
