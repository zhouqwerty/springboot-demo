package com.qwerty.study.springbootdemo.dao.mongodb.secondary;

import com.qwerty.study.springbootdemo.entity.mongodb.Users2;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
* 存储的时候，会根据id选择覆盖还是存储新的，如果没有id元素，那么会创建随机id
* */
public interface User2Repository extends MongoRepository<Users2, String> {

}
