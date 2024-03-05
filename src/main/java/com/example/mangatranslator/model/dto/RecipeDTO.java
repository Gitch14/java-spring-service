package com.example.mangatranslator.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {
    private String title;
    private String description;
    private String type;
    private MediaDTO image;
    private MediaDTO video;
    private String optional;
    private String timeToCookAndPreparing;
    private String timeToCook;
    private String timeToPreparing;
    private String difficulty;
    private List<RecipeStepDTO> steps;
    private List<IngredientDTO> ingredients;
}


