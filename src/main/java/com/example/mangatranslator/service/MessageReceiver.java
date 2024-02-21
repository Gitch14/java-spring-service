package com.example.mangatranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.example.mangatranslator.util.Const.*;

@Slf4j
@Component
public class MessageReceiver {

    @RabbitListener(queues = CREATE_RECIPE_SENDER)
        public void processCreateMessage(String message) {
        log.info("Received create message: " + message);
    }

    @RabbitListener(queues = UPDATE_RECIPE_SENDER)
    public void processUpdateMessage(String message) {
        log.info("Received update message: " + message);
    }

    @RabbitListener(queues = DELETE_RECIPE_SENDER)
    public void processRemoveMessage(String message) {
        log.info("Received remove message: " + message);
    }
}

