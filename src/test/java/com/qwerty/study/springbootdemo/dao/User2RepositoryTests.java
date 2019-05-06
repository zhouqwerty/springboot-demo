package com.qwerty.study.springbootdemo.dao;

import com.qwerty.study.springbootdemo.entity.DemoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User2RepositoryTests {

    @Autowired
    private DemoRepository demoRepository;
    @Test
    public void test() throws Exception {
        DemoEntity demo1=new DemoEntity();
        demo1.setName("测试"+Math.random());
        demoRepository.save(demo1);
    }
}
