package com.r00t.itemserv.messagequeue.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final CachingConnectionFactory cachingConnectionFactory;
    private static final String QUEUE_CREATE_ORDER = "q.createOrder";
    private static final String QUEUE_CHECK_USER = "q.checkUser";
    private static final String QUEUE_CHECK_iTEM = "q.checkItem";

    private static final String TOPIC_EXCHANGE = "TOPIC_EXCHANGE";

    private static final String USER_ROUTING_KEY = "*.user.*";
    private static final String ITEM_ROUTING_KEY = "*.item.*";
    // private static final String CATALOG_ROUTING_KEY = "*.catalog.*";

    public RabbitMQConfig(CachingConnectionFactory cachingConnectionFactory) {
        this.cachingConnectionFactory = cachingConnectionFactory;
    }

    @Bean
    public Queue generateQueue() {
        return new Queue(QUEUE_CREATE_ORDER);
    }

    @Bean
    public Queue generateUserQueue() {
        return new Queue(QUEUE_CHECK_USER);
    }

    @Bean
    public Queue generateItemQueue() {
        return new Queue(QUEUE_CHECK_iTEM);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE.toString());
    }

    @Bean
    public Jackson2JsonMessageConverter object2JSON() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding bindUser() {
        return BindingBuilder.bind(generateUserQueue()).to(topicExchange()).with(USER_ROUTING_KEY);
    }

    @Bean
    public Binding bindItem() {
        return BindingBuilder.bind(generateItemQueue()).to(topicExchange()).with(ITEM_ROUTING_KEY);
    }

}
