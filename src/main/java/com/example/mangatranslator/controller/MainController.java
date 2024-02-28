package com.example.mangatranslator.controller;

import com.example.mangatranslator.repository.UserRepository;
import com.example.mangatranslator.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    //@Autowired
   // private RabbitMQSenderService rabbitMQSenderService;
    @Autowired
    private UserRepository repositoryAcc;
    @Autowired
    private RegistrationService registrationService;
    private final PasswordEncoder passwordEncoder;

    public MainController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


/*
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
     */
}
