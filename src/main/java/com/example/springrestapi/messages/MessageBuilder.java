package com.example.springrestapi.messages;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MessageBuilder {
    public static QueueMessage buildMessage(Object data, String queueName, String routingKey, String topicName) {
        return new QueueMessage(data, routingKey, topicName, queueName);
    }

    public static QueueMessage buildMessage(Object data, String queueName, String routingKey, String topicName,
            UUID messageId) {
        return new QueueMessage(data, routingKey, topicName, queueName, messageId);
    }
}
