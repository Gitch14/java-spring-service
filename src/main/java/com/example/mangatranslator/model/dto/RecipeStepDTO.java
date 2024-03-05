package com.example.mangatranslator.model.dto;

import lombok.Data;

@Data
public class RecipeStepDTO {
    private int stepNumber;
    private String stepName;
    private MediaDTO image;
    private String text;
}
