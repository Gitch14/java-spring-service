package com.example.mangatranslator.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recipe_step")
public class RecipeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private int stepNumber;
    private String stepName;
    private String image;
    private String text;
}
