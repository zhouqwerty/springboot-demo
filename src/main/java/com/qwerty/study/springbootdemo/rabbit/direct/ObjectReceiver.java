package com.qwerty.study.springbootdemo.rabbit.direct;

import com.qwerty.study.springbootdemo.entity.oracle.Users;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void process(Users msg) {
        System.out.println("接收到的对象是" + msg);
    }
}
