package com.example.mangatranslator.service;

import com.example.mangatranslator.model.Recipe;
import com.example.mangatranslator.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    public List<Recipe> listRecipe(){
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }
}
