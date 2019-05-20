package com.qwerty.study.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@Configuration
/*
* maxInactiveIntervalInSeconds是redis session的失效时间，单位是秒
* 这里启用了redis session，原 Spring Boot 的 server.session.timeout 属性不再生效
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 5)
public class SessionConfig {
}
