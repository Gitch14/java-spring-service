package com.example.mangatranslator.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.mangatranslator.util.Const.*;

@Configuration
public class RabbitMQConfig {
    //Create
    @Value("${queue.create-recipe}")
    private String createQueue;
    @Value("${exchange.create-recipe}")
    private String createExchange;
    @Value("${routing-key.create-recipe}")
    private String routingKey_create;

    //Update
    @Value("${queue.update-recipe}")
    private String updateQueue;
    @Value("${exchange.update-recipe}")
    private String updateExchange;
    @Value("${routing-key.update-recipe}")
    private String routingKey_update;

    //Delete
    @Value("${queue.remove-recipe}")
    private String removeQueue;
    @Value("${exchange.remove-recipe}")
    private String removeExchange;
    @Value("${routing-key.remove-recipe}")
    private String routingKey_remove;

    //Registration
    @Value("${queue.reg-user}")
    private String regQueue;
    @Value("${exchange.reg-user}")
    private String regExchange;
    @Value("${routing-key.reg-user}")
    private String routingKey_reg;

    @Bean
    public Queue createQueue() {
        return new Queue(createQueue, false);
    }

    @Bean
    public Queue updateQueue() {
        return new Queue(updateQueue, false);
    }

    @Bean
    public Queue removeQueue() {
        return new Queue(removeQueue, false);
    }

    @Bean
    public Queue registrationQueue() {
        return new Queue(regQueue, false);
    }

    @Bean
    public TopicExchange exchangeCreate(){
        return new TopicExchange(createExchange);
    }

    @Bean
    public TopicExchange exchangeUpdate(){
        return new TopicExchange(updateExchange);
    }

    @Bean
    public TopicExchange exchangeDelete(){
        return new TopicExchange(removeExchange);
    }

    @Bean
    public TopicExchange exchangeRegistration(){
        return new TopicExchange(regExchange);
    }

    @Bean
    public Binding bindingCreate(){
        return BindingBuilder
                .bind(createQueue())
                .to(exchangeCreate())
                .with(routingKey_create);
    }

    @Bean
    public Binding bindingUpdate(){
        return BindingBuilder
                .bind(updateQueue())
                .to(exchangeUpdate())
                .with(routingKey_update);
    }

    @Bean
    public Binding bindingRemove(){
        return BindingBuilder
                .bind(removeQueue())
                .to(exchangeDelete())
                .with(routingKey_remove);
    }

    @Bean
    public Binding bindingRegistration(){
        return BindingBuilder
                .bind(registrationQueue())
                .to(exchangeRegistration())
                .with(routingKey_reg);
    }
}
