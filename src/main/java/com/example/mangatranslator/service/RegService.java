package com.example.mangatranslator.service;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;



    public RegService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public void registration(User user)
    {
        user.setEmail("user");
        user.setPassword(passwordEncoder.encode("111"));
        user.setName("user");

        JSONObject userJson = new JSONObject();

        userJson.put("email", "user");
        userJson.put("user", "user");
        userJson.put("password", "111");


        rabbitMQSenderService.sendRegInfoMessage(userJson.toString());
    }
}
