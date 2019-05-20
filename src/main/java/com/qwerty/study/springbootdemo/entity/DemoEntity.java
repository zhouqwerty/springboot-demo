package com.qwerty.study.springbootdemo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;


@Entity
public class DemoEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid",strategy = "uuid")
    private String pid;
    @Column(nullable = true)
    private String name;
    @Column(columnDefinition="date default sysdate")
    private Date time;
    private Date time2;

    public String getPid() {
        return pid;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DemoEntity{" +
                "pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", time2=" + time2 +
                '}';
    }
}
