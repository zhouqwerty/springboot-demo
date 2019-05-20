package com.qwerty.study.springbootdemo.rabbit.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanout.A")
    @RabbitHandler
    public void processA(String msg) {
        System.out.println("A接收到的消息:" + msg);
    }

    @RabbitListener(queues = "fanout.B")
    @RabbitHandler
    public void processB(String msg) {
        System.out.println("B接收到的消息:" + msg);
    }

    @RabbitListener(queues = "fanout.C")
    @RabbitHandler
    public void processC(String msg) {
        System.out.println("C接收到的消息:" + msg);
    }
}
