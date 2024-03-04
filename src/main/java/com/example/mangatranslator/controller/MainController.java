package com.example.mangatranslator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.mangatranslator.util.Const.*;

@Controller
public class MainController {
    @GetMapping(ABOUT_US)
    String about() {
        return "about";
    }

    @GetMapping(PRIVACY)
    String privacy() {
        return "privacy";
    }

    @GetMapping(FAQ)
    String faq() {
        return "faq";
    }
}
