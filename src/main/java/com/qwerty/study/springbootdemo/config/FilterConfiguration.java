package com.qwerty.study.springbootdemo.config;

import com.qwerty.study.springbootdemo.filter.TestFilter1;
import com.qwerty.study.springbootdemo.filter.TestFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {


    /*像这种直接返回Filter的方法，就是使用Filter的默认配置*/
    @Bean
    public TestFilter1 testFilter1(){
        return new TestFilter1();
    }

    @Bean
    public TestFilter2 testFilter2(){
        return new TestFilter2();
    }

/*------------------------------------------------------------分割线-----------------------------------------------------------------*/

    /*如果想修改Filter的配置，则可以返回FilterRegistrationBean对象*/
    @Bean
    public FilterRegistrationBean registrationFilter1(){
        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new TestFilter1());
        registration.addUrlPatterns("/test/test1");
        registration.addInitParameter("p1","v1");
        registration.setName("f1");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean registrationFilter2(){
        FilterRegistrationBean registration=new FilterRegistrationBean();
        registration.setFilter(new TestFilter2());
        registration.addUrlPatterns("/test/test2");
        registration.addInitParameter("p1","v1");
        registration.setName("f2");
        registration.setOrder(1);
        return registration;
    }
}

