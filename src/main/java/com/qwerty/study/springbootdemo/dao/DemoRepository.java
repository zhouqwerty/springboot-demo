package com.qwerty.study.springbootdemo.dao;

import com.qwerty.study.springbootdemo.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoRepository extends JpaRepository<DemoEntity,String>{
    DemoEntity findByPid(String id);
}
