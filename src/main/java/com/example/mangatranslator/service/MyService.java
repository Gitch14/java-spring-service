package com.example.mangatranslator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final MessageSenderService messageSender;

    @Autowired
    public MyService(MessageSenderService messageSender) {
        this.messageSender = messageSender;
    }

    public void someMethod() {
        // send message in queue with name myQueue
        messageSender.sendMessage("myQueue", "Hello, RabbitMQ!");
    }
}
