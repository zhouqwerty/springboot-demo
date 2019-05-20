package com.qwerty.study.springbootdemo.dao;

import com.qwerty.study.springbootdemo.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DemoRepository extends JpaRepository<DemoEntity,String> {
    DemoEntity findByPid(String id);
    @Transactional//貌似自己写的delete方法没有默认开启事务
    int deleteByName(String name);

    /*@Query("select d from DemoEntity d where d.name=?1")
    List<DemoEntity> findDemo(String name);

    @Query("select d from DemoEntity d where d.name=?1")
    这里要注意，当我们使用@query自定义查询的时候，等于放弃了jpa默认使用的方法名
    解析成sql语句的模式，如果我们的sql语句是增删改语句，要加@Modifying
    List<CommonEntity> findDemo2(String name);*/


}
