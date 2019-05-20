package com.qwerty.study.springbootdemo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* 关于RabbitMQ的理解：
* 名词解释：
* 生产者：发送消息
* 理解：生产的消息需要携带exchange的名字，如果没有就是发送给默认的direct交换器
*
* 消费者：消费消息
* 理解：消费消息的是指定某一个队列名字，没有任何参数，来多少消费多少
*
* exchange：交换器  direct，topic，fanout
*理解：共有三种类型，按照绑定的规则发放，没找到就抛弃
*
* queue：队列 队列是没有类型区别的
* 理解：创建队列的时候，会绑到默认的direct交换器，routing_key默认为队列的名字
* 队列可以绑定很多exchange
*
* 这四个是完全独立的，是没有耦合的四个对象
*
* */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue Queue2() {
        return new Queue("object");
    }

    @Bean
    DirectExchange exchange2() {
        return new DirectExchange("directExchange");
    }


    @Bean
    Binding bindingExchangeMessages2(Queue Queue, DirectExchange exchange2) {
        return BindingBuilder.bind(Queue).to(exchange2).with("hello2");
    }

}
