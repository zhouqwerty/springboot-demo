package com.qwerty.study.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${com.qwerty.title}")
    private String title;
    @Value("${com.qwerty.name}")
    private String name;

    @RequestMapping("/test1")
    public String test1(){
        System.out.println(name);
        return "Hello World";
    }

    @RequestMapping("/test2")
    public String test2(){
        return name+":"+title;
    }


}
