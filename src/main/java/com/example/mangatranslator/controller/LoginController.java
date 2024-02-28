package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.mangatranslator.util.Const.*;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping(HOME_PAGE)
    public String mainPage() {
        return "index";
    }
    @GetMapping(LOGIN_PAGE)
    String login() {
        return "login";
    }

    @GetMapping(REGISTRATION_PAGE)
    String reg() {
        return "registration";
    }

    @PostMapping(CREATE_USER)
    public String registerUser(@RequestParam("email") String email,
                               @RequestParam("name") String name,
                               @RequestParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        log.info("Email: " + user.getEmail() + "\n" + "Name: " + user.getName() + "\n" + "Password: " + user.getPassword());

        registrationService.registration(user);

        return "redirect:/login";
    }

}
