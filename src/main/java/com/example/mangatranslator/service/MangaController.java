package com.example.mangatranslator.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MangaController {
    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

}