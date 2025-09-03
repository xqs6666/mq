package com.xian.producter.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration implements ApplicationContextAware {
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RabbitTemplate rabbitTemplate = applicationContext.getBean(RabbitTemplate.class);

        rabbitTemplate.setReturnsCallback(returnedMessage->{
            System.out.println("收到消息的return callback, " +
                    "exchange = " + returnedMessage.getExchange() + ", " +
                    "routingKey = " + returnedMessage.getRoutingKey() + ", " +
                    "replyCode = " + returnedMessage.getReplyCode() + ", " +
                    "replyText = " + returnedMessage.getReplyText() + ", " +
                    "message = " + returnedMessage.getMessage());
        });
    }
}
