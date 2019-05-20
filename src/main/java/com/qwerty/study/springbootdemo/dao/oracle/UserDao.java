package com.qwerty.study.springbootdemo.dao.oracle;

import com.qwerty.study.springbootdemo.entity.oracle.Users;
import org.apache.ibatis.annotations.Insert;

//@Mapper
public interface UserDao {

    @Insert("insert into users(name,password) values(#{name},#{password})")
    int addUser(Users u);

//    @Select("SELECT * FROM users")
//    List<Users> queryUser();

}
