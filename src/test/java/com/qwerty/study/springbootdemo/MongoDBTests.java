package com.qwerty.study.springbootdemo;


import com.qwerty.study.springbootdemo.dao.mongodb.primary.UserRepository;
import com.qwerty.study.springbootdemo.dao.mongodb.secondary.User2Repository;
import com.qwerty.study.springbootdemo.entity.mongodb.Users;
import com.qwerty.study.springbootdemo.entity.mongodb.Users2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private User2Repository user2Repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void save(){
        Users users=new Users();
        users.setId("1");
//        users.setName("test");
        users.setPassword("123");
        mongoTemplate.save(users,"test");
    }
    @Test
    public void save2(){
        com.qwerty.study.springbootdemo.entity.oracle.Users users=new com.qwerty.study.springbootdemo.entity.oracle.Users();
        users.setId("4");
        users.setName("test");
        users.setPassword("1234");
//        userRepository.saveUser(users);
    }
    @Test
    public void save3(){
        Users2 users=new Users2();
        users.setName("test");
        users.setPassword("123");
        mongoTemplate.save(users);
    }
    @Test
    public void save4(){
        Users users=new Users();
        users.setName("test");
        users.setPassword("123");
        userRepository.save(users);
        Users2 users2=new Users2();
        users2.setName("test");
        users2.setPassword("123");
        user2Repository.save(users2);
    }

    @Test
    public void save5(){
        Map<String,MongoTemplate> map=applicationContext.getBeansOfType(MongoTemplate.class);
        System.out.println("---------------------"+map.size()+"-----------------");
        for(Map.Entry<String,MongoTemplate> s:map.entrySet()){
            System.out.println(s.getKey()+":"+s.getValue());
        }

    }


    @Test
    public void query(){
        Query query=new Query(Criteria.where("name").is("test"));
        List<Users> user =  mongoTemplate.find(query , Users.class);
        System.out.println(user);
    }

    @Test
    public void query2(){
        Query query=new Query(Criteria.where("password").is("123"));
        List<Users2> user =  mongoTemplate.find(query , Users2.class);
        System.out.println(user);
    }

    @Test
    public void query3(){
        Query query=new Query(Criteria.where("password").is("123"));
        List<Users> user =  mongoTemplate.find(query , Users.class);
        System.out.println(user);
    }

}
