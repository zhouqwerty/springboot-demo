package com.qwerty.study.springbootdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("test1::::2","test4");
//        stringRedisTemplate.opsForValue().set("test11:22:22:22","test4");
//        stringRedisTemplate.opsForValue().set("test11::33::33::33","test4");
    }

    @Test
    public void testHas() throws Exception {
         System.out.println(
                 redisTemplate.hasKey("test1")
        );
        System.out.println(redisTemplate.opsForValue().get("test1"));
        ValueOperations<String,String> operations=redisTemplate.opsForValue();
        System.out.println(operations.get("test1"));
    }

    @Test
    public void testObj() throws Exception {
        /*DemoEntity demo=new DemoEntity();
        demo.setName("123");
        demo.setPid("12312");
        demo.setTime(new Date(new java.util.Date().getTime()));
        ValueOperations<String,DemoEntity> operations=redisTemplate.opsForValue();
        operations.set("test2",demo);
        operations.set("test3",demo,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("test2");
        if(exists){
            System.out.println(
                    "存在"
            );
        }else{
            System.out.println(
                    "不存在"
            );
        }

    }

    @Test
    public void testObj2() throws Exception {
        DemoEntity demo=new DemoEntity();
        demo.setName("86541");
        demo.setPid("12312");
        ValueOperations<DemoEntity,DemoEntity> operations=redisTemplate.opsForValue();
        operations.set(demo,demo);*/
    }

    @Test
    public void testObj3() throws Exception {
       /* DemoEntity demo=new DemoEntity();
        demo.setName("86541");
        demo.setPid("12312");
        ValueOperations<DemoEntity,DemoEntity> operations=redisTemplate.opsForValue();
        System.out.println(operations.get(demo).getName());*/
    }
}
