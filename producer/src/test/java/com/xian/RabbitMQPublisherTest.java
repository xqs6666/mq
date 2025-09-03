package com.xian;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
public class RabbitMQPublisherTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void fanoutTest() throws Exception{
        String exchangeName = "xqs.fanout";
        rabbitTemplate.convertAndSend(exchangeName, "", "fanout.message");
    }

    @Test
    public void directTest() throws Exception{
        String exchangeName = "xqs.direct";
//        rabbitTemplate.convertAndSend(exchangeName, "red", "red msg");
        rabbitTemplate.convertAndSend(exchangeName, "blue", "blue msg");
    }

    @Test
    public void topicTest() throws Exception{
        String exchangeName = "xqs.topic";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", "china.news");

        rabbitTemplate.convertAndSend(exchangeName, "hello.news", "china.news");
    }

    @Test
    public void topicSpringTest1() throws Exception{
        String exchangeName = "spring.topic";
        rabbitTemplate.convertAndSend(exchangeName, "queue2.queue1", "queue2.queue1.msg");

    }

    @Test
    public void topicSpringTest2() throws Exception{
        String exchangeName = "spring.topic";
        rabbitTemplate.convertAndSend(exchangeName, "queue2.h1", "queue2.msg");

    }

    @Test
    public void topicSpringTest3() throws Exception{
        String exchangeName = "spring.topic";
        rabbitTemplate.convertAndSend(exchangeName, "h2.queue1", "queue1.msg");

    }

    @Test
    public void topicSpringTest4() throws Exception{
        String exchangeName = "spring.topic";
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name", "xqs");
        hashMap.put("age", 18);
        rabbitTemplate.convertAndSend(exchangeName, "h2.queue1", hashMap);

    }





}
