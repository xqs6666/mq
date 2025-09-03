package com.xian.consumer.listeners;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("spring.topic");
    }

    @Bean
    public Queue queue1(){
        return new Queue("spring.queue1");
    }

    @Bean
    public Queue queue2(){
        return new Queue("spring.queue2");
    }

    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("#.queue1");
    }

    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("queue2.#");
    }
}
