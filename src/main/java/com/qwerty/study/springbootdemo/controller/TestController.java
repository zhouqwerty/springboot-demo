package com.qwerty.study.springbootdemo.controller;

import com.qwerty.study.springbootdemo.entity.DemoEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;


@RestController
@RequestMapping("/test")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${com.qwerty.title}")
    private String title;
    @Value("${com.qwerty.name}")
    private String name;

    @RequestMapping("/test1")
    @Cacheable(value = "test11")
    public String test1(){
        logger.info("当前是/test/test1请求的日志");
        System.out.println(name);
        return "12356666";
    }

    @RequestMapping("/test2")
    @Cacheable(value = "test123")
    public String testqwe(){
        System.out.println("222");
        return name+":"+title;
    }

    @RequestMapping("/test3")
    public String test3() throws Exception{
        boolean flag=true;
        if(flag){
            throw new Exception();
        }
        return "12356666";
    }

    @RequestMapping("/test4")
    public DemoEntity test4() throws Exception{
        DemoEntity demo=new DemoEntity();
        demo.setPid("1");
        demo.setName("2");
        demo.setTime(new Date());
        return demo;
    }

    @RequestMapping("/uid")
    public String testRedisSession(HttpSession session){
        UUID uid=(UUID)session.getAttribute("uid");
        if(uid==null){
            uid=UUID.randomUUID();
        }
        System.out.println(uid);
        session.setAttribute("uid",uid);
        return session.getId();
    }
}
