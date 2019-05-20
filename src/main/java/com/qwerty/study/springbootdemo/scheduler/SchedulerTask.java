package com.qwerty.study.springbootdemo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
* fixedRate = 6000  上一次开始执行时间点之后6秒再执行
*fixedDelay = 6000  上一次执行完毕时间点之后6秒再执行
*initialDelay=1000, fixedRate=6000 第一次延迟1秒后执行，之后按 fixedRate 的规则每6秒执行一次
* */
//@Component
public class SchedulerTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private int count=0;

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

    @Scheduled(cron="*/6 * * * * ?")
    public void reportCount() {
        System.out.println("现在：" + count++);
    }

}
