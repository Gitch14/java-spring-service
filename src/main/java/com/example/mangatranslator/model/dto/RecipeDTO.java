package com.example.mangatranslator.model.dto;

import lombok.Data;

import org.joda.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class RecipeDTO {
    private String title;
    private String description;
    private String type;
    private Long userId;
    private MediaDTO image;
    private MediaDTO video;
    private String optional;
    private String timeToCookAndPreparing;
    private String timeToCook;
    private String timeToPreparing;
    private String difficulty;
    private LocalDateTime dataPublish;
    private List<RecipeStepDTO> steps;
    private List<IngredientDTO> ingredients;
}


