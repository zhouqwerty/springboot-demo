package com.qwerty.study.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/*
* 关于@RefreshScope的一个巨坑
* 具体原因不清楚，暂时描述问题以及解决办法
* 问题：按照教程配置一样的项目，可是refresh一直无效
* 排查过程：
* （1）首先发现refresh请求返回的是302，查看控制台只有一个关于datasource的警告，其他都正常
* （2）新建一个最简单的项目，只有springcloud config client的内容，发现refresh正常
* （3）于是想在这个简单的demo中也加入数据库配置，但是发现单数据源的配置方式报错（提示datasource已被注册）
*      可是去掉springcloud config配置，数据库启动正常
*      猜想：在没有config的时候，单数据源默认是读取本地配置里的数据库信息
*            当有config的时候，默认会去远程config中心读取数据库信息，不管读没读到，
*            datatsource都会被默认使用
* （4）于是采用自定义单数据源的方式解决，重新refresh，这时报了下面这个错误
*      The configuration of the pool is sealed once started.
*      Use HikariConfigMXBean for runtime changes.
*      大概的意思就是：数据池在启动之后就被密封了 因此导致了错误
*      解决办法：在自定义的数据源上面加上@RefreshScope注解即可
*                 此方法同样适用于多数据源
* 疑问：这里我们只是简单的去读取配置文件，根本和datasource无关，也没有想动态的修改数据库的配置信息
*       但是这里依然要给数据源加上@RefreshScope注解才可以
* */
@RestController
@RequestMapping("/test")
@RefreshScope// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${com.qwerty.title}")
    private String title;
    @Value("${com.qwerty.name}")
    private String name;

    @Value("${test}")
    private String config;

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

    @RequestMapping("/test5")
    public String test5() throws Exception{
        return config;
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
