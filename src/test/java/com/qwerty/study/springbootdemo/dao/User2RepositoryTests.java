package com.qwerty.study.springbootdemo.dao;

import com.qwerty.study.springbootdemo.dao.mysql.PeopleDao;
import com.qwerty.study.springbootdemo.dao.oracle.UserDao;
import com.qwerty.study.springbootdemo.entity.mysql.People;
import com.qwerty.study.springbootdemo.entity.oracle.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class User2RepositoryTests {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PeopleDao peopleDao;

    @Test
    public void testMybatis() throws Exception {
        Users u=new Users();
        u.setName("123");
        u.setPassword("123");
        userDao.addUser(u);
        People p=new People();
        p.setName("123");
        p.setPassword("123");
        peopleDao.addPeople(p);
//        System.out.println( userDao.queryUser());
    }

    @Test
    public void testMybatis2() throws Exception {
        People p=new People();
        p.setName("123");
        p.setPassword("123");
        peopleDao.addPeople(p);
//        System.out.println( userDao.queryUser());
    }

    @Test
    public void test2() throws Exception {
        //存储
        /*DemoEntity demo=new DemoEntity();
        demo.setPid("123");
        demo.setName("test2");
        demo.setTime(new Date());
        demo.setTime2(new Date());
        demoRepository.save(demo);*/
        //查询全部
//        System.out.println(demoRepository.findAll());
        //查询全部
        /*System.out.println(demoRepository.findById("297eaa866a977629016a97763cce0000"));
        Optional<DemoEntity> ops=demoRepository.findById("297eaa866a977629016a97763cce0000");*/
        //根据名字删除
//        System.out.println(demoRepository.deleteByName("test"));
        //分页查询
        /*Sort sort=new Sort(Sort.Direction.DESC,"time");
        Pageable pageable=new PageRequest(1,2,sort);
        System.out.println(demoRepository.findAll(pageable));*/
//        自定义查询
//        System.out.println(demoRepository.findDemo("test2"));
//        System.out.println(demoRepository.findDemo2("test2"));
        /*List<CommonEntity> list=demoRepository.findDemo2("test2");
        for (CommonEntity c:list){
            System.out.println(c.getPid());
        }*/
    }
}
