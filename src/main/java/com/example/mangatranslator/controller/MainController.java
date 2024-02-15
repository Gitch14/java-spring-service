package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/createNew")
    public String mainPageS() {
        return "new-recipe";
    }

    @PostMapping("/saveNew")
    public Recipe mainPageP() {
        //Service service = new Service();
        //service.new();
        Recipe recipe = new Recipe();
        return recipe;
    }

}
