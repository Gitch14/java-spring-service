package com.example.mangatranslator.service;

import com.example.mangatranslator.model.Difficulty;
import com.example.mangatranslator.model.Ingredient;
import com.example.mangatranslator.model.Recipe;
import com.example.mangatranslator.model.RecipeStep;
import com.example.mangatranslator.model.dto.IngredientDTO;
import com.example.mangatranslator.model.dto.RecipeDTO;
import com.example.mangatranslator.model.dto.RecipeStepDTO;
import com.example.mangatranslator.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.mangatranslator.util.MediaUtils.encodeImageToBase64;

@Service
@Slf4j
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    public List<Recipe> listRecipe(){
        return recipeRepository.findAll();
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public void createRecipe() throws IOException {

        String image = "data:image/png;base64,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";
        // Создание DTO для рецепта
        RecipeDTO recipeDTO = createRecipeDTO();
        recipeDTO.setUserId(1L);


        // Создание DTO для шага рецепта
        RecipeStepDTO recipeStepDTO = new RecipeStepDTO();
        recipeStepDTO.setStepNumber(1);
        recipeStepDTO.setStepName("Step 1");
        recipeStepDTO.setText("Your step text...");
        recipeStepDTO.setImage(encodeImageToBase64(image));


        // Добавление шага рецепта к DTO рецепта
        recipeDTO.getSteps().add(recipeStepDTO);

        // Отправка DTO рецепта в RabbitMQ
        rabbitMQSenderService.sendCreateMessage(recipeDTO);
    }

    private RecipeDTO createRecipeDTO() {
        // Создание DTO для рецепта
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setTitle("Your Recipe Title");
        recipeDTO.setDescription("Your Recipe Description");



        // Создание DTO для ингредиентов
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient1 = new IngredientDTO();
        ingredient1.setName("chocolate");
        ingredient1.setValue("300 g");
        ingredients.add(ingredient1);

        IngredientDTO ingredient2 = new IngredientDTO();
        ingredient2.setName("milk");
        ingredient2.setValue("500 ml");
        ingredients.add(ingredient2);

        IngredientDTO ingredient3 = new IngredientDTO();
        ingredient3.setName("strawberry");
        ingredient3.setValue("150 g");
        ingredients.add(ingredient3);

        recipeDTO.setIngredients(ingredients);

        recipeDTO.setSteps(new ArrayList<>());

        return recipeDTO;
    }

}
