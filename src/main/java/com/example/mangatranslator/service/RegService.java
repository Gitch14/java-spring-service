package com.example.mangatranslator.service;

import com.example.mangatranslator.model.User;
import com.example.mangatranslator.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;



    public RegService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User registration(User user)
    {
        user.setEmail("user");
        user.setPassword(passwordEncoder.encode("111"));
        user.setName("user");



        return userRepository.save(user);
    }
}
