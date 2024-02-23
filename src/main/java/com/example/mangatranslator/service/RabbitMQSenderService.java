package com.example.mangatranslator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQSenderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${exchange.create-recipe}")
    private String exchange;
    @Value("${routing-key.create-recipe}")
    private String routingKey;

    public void sendCreateMessage(String message) {
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendUpdateMessage(String message) {
        rabbitTemplate.convertAndSend(exchange,routingKey,"hello world! update");
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

    public void sendRemoveMessage(String message) {
        rabbitTemplate.convertAndSend(exchange,routingKey,"hello world! remove");
        log.info(" [x] Sent to create queue: '" + message + "'");
    }

}
