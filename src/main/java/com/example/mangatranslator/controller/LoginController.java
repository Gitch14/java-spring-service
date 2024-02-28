package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private RegService regService;
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/registration")
    String reg() {
       // regService.registration(new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        regService.registration(user);
        return "redirect:/login";
    }



}
