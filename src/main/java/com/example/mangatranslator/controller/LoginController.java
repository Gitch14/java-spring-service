package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
        regService.registration(new User());
        return "registration";
    }



}
