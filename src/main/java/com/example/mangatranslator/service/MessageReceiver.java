package com.example.mangatranslator.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.mangatranslator.util.Const.STATUS_RECIPE_SENDER;

@Component
public class MessageReceiver {

    @RabbitListener(queues = STATUS_RECIPE_SENDER)
    public void receiveMessage(String message) {
        System.out.println("Received message from 'myQueue': " + message);
    }
}

