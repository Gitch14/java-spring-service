package com.example.mangatranslator.controller;

import com.example.mangatranslator.model.User1;
import com.example.mangatranslator.repository.User1Repository;
import com.example.mangatranslator.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private MyService myService;
    @Autowired
    private User1Repository repository;

    @GetMapping("/")
    public List<User1> mainPage() {
        List<User1> list = new ArrayList<>();
        list = repository.findAll();
      //  myService.someMethodForNew();
        return list;
    }

    @GetMapping("/createNew")
    public String mainPageS() {
        return "new-recipe";
    }

}
