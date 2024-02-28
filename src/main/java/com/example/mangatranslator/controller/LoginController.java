package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.model.User1;
import com.example.mangatranslator.service.RegService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private RegService regService;

    @GetMapping("/")
    public String mainPage() {
        /*
        List<User1> list = repository.findAll();
        rabbitMQSenderService.sendCreateMessage("create");
        rabbitMQSenderService.sendUpdateMessage("update");
        rabbitMQSenderService.sendRemoveMessage("remove");
        return list;
         */
        return "index";
    }
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/registration")
    String reg() {
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
        log.info("Email: " + user.getEmail() + "\n" + "Name: " + user.getName() + "\n" + "Password: " + user.getPassword());

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
