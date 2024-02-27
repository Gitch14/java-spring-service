package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.model.User1;
import com.example.mangatranslator.repository.User1Repository;
import com.example.mangatranslator.repository.UserRepository;
import com.example.mangatranslator.service.RabbitMQSenderService;
import com.example.mangatranslator.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;
    @Autowired
    private User1Repository repository;
    @Autowired
    private UserRepository repositoryAcc;
    @Autowired
    private RegService regService;
    private final PasswordEncoder passwordEncoder;

    public MainController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }



    @GetMapping("/")
    public List<User1> mainPage() {
        List<User1> list = repository.findAll();
        rabbitMQSenderService.sendCreateMessage("create");
        rabbitMQSenderService.sendUpdateMessage("update");
        rabbitMQSenderService.sendRemoveMessage("remove");
        return list;
    }

    @PostMapping("/create")
    public ResponseEntity<User> registerUser() {
        User user = new User();
        user.setName("user");
        user.setPassword(passwordEncoder.encode("111"));
        user.setEmail("user");

        repositoryAcc.save(user);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/createNew")
    public String mainPageS() {
        regService.registration(new User());
        return "new-recipe";
    }

    @GetMapping("/t")
    public String mainPageTest() {
        return "test";
    }

}
