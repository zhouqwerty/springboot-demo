package com.qwerty.study.springbootdemo.rabbit.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("2接收到的消息是" + msg);
    }
}
