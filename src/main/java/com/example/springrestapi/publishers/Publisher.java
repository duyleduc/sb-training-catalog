package com.example.springrestapi.publishers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springrestapi.configurations.RabbitMQConfig;
import com.example.springrestapi.messages.QueueMessage;

@Component
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(QueueMessage message, String routingKey) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, routingKey, message);
    }

}