package com.qwerty.study.springbootdemo;

import com.qwerty.study.springbootdemo.config.memcached.MemcachedRunner;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedTests {

    @Autowired
    private MemcachedRunner memcachedRunner;

    @Test
    public void testMemcachedClient(){
        MemcachedClient client=memcachedRunner.getClient();
        client.set("test4",30,"HelloWorld!!!");
        client.set("test5",0,"HelloWorld!!!");
        client.set("test6",-1,"HelloWorld!!!");
    }

}
