package com.qwerty.study.springbootdemo.dao.mysql;

import com.qwerty.study.springbootdemo.entity.mysql.People;
import org.apache.ibatis.annotations.Insert;

public interface PeopleDao {
    @Insert("insert into people(name,password) values(#{name},#{password})")
    int addPeople(People u);
}
