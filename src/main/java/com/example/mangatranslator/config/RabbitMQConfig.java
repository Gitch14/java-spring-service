package com.example.mangatranslator.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.mangatranslator.util.Const.*;

@Configuration
public class RabbitMQConfig {
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        return new RabbitTemplate(connectionFactory);
    }


    @Bean
    public Queue createQueue() {
        return new Queue(CREATE_RECIPE_SENDER, false);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(UPDATE_RECIPE_SENDER, false);
    }

    @Bean
    public Queue removeQueue() {
        return new Queue(DELETE_RECIPE_SENDER, false);
    }
}
