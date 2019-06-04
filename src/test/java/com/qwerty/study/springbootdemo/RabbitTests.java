package com.qwerty.study.springbootdemo;

import com.qwerty.study.springbootdemo.entity.oracle.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send(){
        String context="test"+new Date();
        for(int i=0;i<100;i++){
            rabbitTemplate.convertAndSend("hello",i+"");
        }
    }

    @Test
    public void sendObject(){
        Users users=new Users();
        users.setId("1");
        users.setName("test");
        users.setPassword("123");
        rabbitTemplate.convertAndSend("object",users);
    }

    @Test
    public void sendTopic(){
        rabbitTemplate.convertAndSend("exchange","topic.messages","123");
    }

    @Test
    public void send2(){
        String context="test"+new Date();
        rabbitTemplate.convertAndSend("directExchange","hello2",context);
    }


    @Test
    public void send3(){
        String context="test"+new Date();
        rabbitTemplate.convertAndSend("topic.message",context);
    }

    @Test
    public void sendFanout(){
        String context="test"+new Date();
        rabbitTemplate.convertAndSend("fanoutExchange","",context);
    }

}
