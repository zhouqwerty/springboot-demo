package com.qwerty.study.springbootdemo.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 这个类是用来初始化一些东西的
 * 它的执行时机是bean初始化完毕，run（启动）应用之前执行
 * 假如我们有很多个初始化类，可以通过@Order注解来决定先后顺序
 * */
@Component
@Order(1)
public class InitRunner implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        System.out.println("app is ready to init ......");
    }
}
