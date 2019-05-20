package com.qwerty.study.springbootdemo.dto;

import java.util.Date;

public interface CommonEntity {
    String getPid();
    String getName();
    Date getTime();
    Date getTime2();
    default Integer getTest(){
        return 0;
    }
}
