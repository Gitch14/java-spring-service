package com.example.mangatranslator.service;

import com.example.mangatranslator.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    public RegistrationService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public void registration(User user) {
        String email = user.getEmail();
        String name = user.getName();
        String password = passwordEncoder.encode(user.getPassword());

        JSONObject userJson = new JSONObject();

        userJson.put("email", email);
        userJson.put("user", name);
        userJson.put("password", password);


        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);

        rabbitMQSenderService.sendRegInfoMessage(user);
    }
}
