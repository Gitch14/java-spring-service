package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.Recipe;
import com.example.mangatranslator.service.RabbitMQSenderService;
import com.example.mangatranslator.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

import static com.example.mangatranslator.util.Const.*;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping(CATALOG_PAGE)
    String catalog(Model model) {
        model.addAttribute("recipe",recipeService.listRecipe());
        return "catalog";
    }

    @GetMapping(RECIPE_PAGE)
    String recipe(Model model,@PathVariable(value = "id") long id) {
        model.addAttribute("recipe",recipeService.getRecipeById(id));
        return "recipe-page";
    }


    @GetMapping(CREATE_RECIPE_PAGE)
    String recipeCreatePage() throws IOException {
        recipeService.createRecipe();
        return "redirect:/";
    }

    @PostMapping(CREATE_RECIPE)
    public String createRecipe(Recipe recipe) {

        return "redirect:/my/posts";
    }

    @GetMapping(UPDATE_RECIPE_PAGE)
    String recipeUpdatePage() {

        return "recipe-create";
    }

    @PostMapping(UPDATE_RECIPE)
    public String updateRecipe(Recipe recipe) {

        return "redirect:/my/posts";
    }

    @PostMapping(DELETE_RECIPE)
    public String deleteRecipe(Recipe recipe) {

        return "redirect:/my/posts";
    }
}
