package com.xian.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.xml.ws.BindingType;
import java.util.HashMap;

@Component
public class MQListener {

    @RabbitListener(queues = {"fanout.queue1"})
    public void receive1(String msg){
        System.out.println("queue1接收到消息："+msg);
    }

    @RabbitListener(queues = {"fanout.queue2"})
    public void receive2(String msg){
        System.out.println("queue2接收到消息："+msg);
    }

    //blue red
    @RabbitListener(queues = {"direct.queue1"})
    public void receive3(String msg){
        System.out.println("direct.queue1接收到消息："+msg);
    }

    //red yellow
    @RabbitListener(queues = {"direct.queue2"})
    public void receive4(String msg){
        System.out.println("direct.queue2接收到消息："+msg);
    }


    @RabbitListener(queues = {"topic.queue1"})
    public void receive5(String msg){
        System.out.println("topic.queue1接收到消息："+msg);
    }

    @RabbitListener(queues = {"topic.queue2"})
    public void receive6(String msg){
        System.out.println("topic.queue2接收到消息："+msg);
    }


    @RabbitListener(queues = {"spring.queue1"})
    public void receive7(HashMap<String, Object> hashMap){
        System.out.println("spring.queue1接收到消息："+hashMap);
    }

    @RabbitListener(queues = {"spring.queue2"})
    public void receive8(HashMap<String, Object> hashMap){
        System.out.println("spring.queue2接收到消息："+hashMap);
    }
}
