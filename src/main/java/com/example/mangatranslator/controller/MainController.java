package com.example.mangatranslator.controller;

import com.example.mangatranslator.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private MyService myService;

    @GetMapping("/")
    public String mainPage() {
        myService.someMethodForNew();
        return "index";
    }

    @GetMapping("/createNew")
    public String mainPageS() {
        return "new-recipe";
    }

}
