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
    @Autowired
    private UserRepository userRepository;



    public RegService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public void registration(User user)
    {
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



        rabbitMQSenderService.sendRegInfoMessage(userJson.toString());
        userRepository.save(user);
    }

    public void registration1()
    {

        JSONObject userJson = new JSONObject();

        userJson.put("email", "user");
        userJson.put("user", "user");
        userJson.put("password", "111");


        rabbitMQSenderService.sendRegInfoMessage(userJson.toString());
    }
}
