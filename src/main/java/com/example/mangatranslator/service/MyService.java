package com.example.mangatranslator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.mangatranslator.util.Const.*;


@Service
public class MyService {

    private final MessageSenderService messageSender;

    @Autowired
    public MyService(MessageSenderService messageSender) {
        this.messageSender = messageSender;
    }

    public void someMethodForNew() {
        messageSender.sendMessage(CREATE_RECIPE_SENDER, "Hello, RabbitMQ!(new)");
    }

    public void someMethodForUpdate() {
        messageSender.sendMessage(UPDATE_RECIPE_SENDER, "Hello, RabbitMQ!(update)");
    }

    public void someMethodForDelete() {
        messageSender.sendMessage(DELETE_RECIPE_SENDER, "Hello, RabbitMQ!(delete)");
    }
}
