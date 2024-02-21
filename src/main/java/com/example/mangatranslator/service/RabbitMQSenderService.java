package com.example.mangatranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue createQueue;

    @Autowired
    private Queue updateQueue;

    @Autowired
    private Queue removeQueue;

    public void sendCreateMessage(String message) {
        rabbitTemplate.convertAndSend(createQueue.getName(), message);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendUpdateMessage(String message) {
        rabbitTemplate.convertAndSend(updateQueue.getName(), message);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendRemoveMessage(String message) {
        rabbitTemplate.convertAndSend(removeQueue.getName(), message);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }
}
