package com.example.mangatranslator.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.mangatranslator.util.Const.*;

@Configuration
public class RabbitMQConfig {
    @Value("${queue.create-recipe}")
    private String createQueue;
    @Value("${queue.update-recipe}")
    private String updateQueue;
    @Value("${queue.remove-recipe}")
    private String removeQueue;

    @Value("${exchange.create-recipe}")
    private String createExchange;
    @Value("${routing-key.create-recipe}")
    private String routingKey_create;

    @Bean
    public Queue createQueue() {
        return new Queue(createQueue, true);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(updateQueue, true);
    }

    @Bean
    public Queue removeQueue() {
        return new Queue(removeQueue, true);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(createExchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(createQueue())
                .to(exchange())
                .with(routingKey_create);
    }
}
