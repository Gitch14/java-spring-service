package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        regService.registration1();
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);

        regService.registration(user);

        return "redirect:/login";
    }

    /*
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        regService.registration(user);
        return "redirect:/login";
    }

     */



}
