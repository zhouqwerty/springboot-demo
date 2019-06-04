package com.qwerty.study.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling//开启定时服务
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		System.out.println("the service to start");
		SpringApplication.run(SpringbootDemoApplication.class, args);
		System.out.println("the service has started");
	}

}
