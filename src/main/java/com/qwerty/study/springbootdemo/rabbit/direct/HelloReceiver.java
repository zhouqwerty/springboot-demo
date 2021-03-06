package com.qwerty.study.springbootdemo.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String msg) {
        System.out.println("1接收到的消息是" + msg);
    }
}
