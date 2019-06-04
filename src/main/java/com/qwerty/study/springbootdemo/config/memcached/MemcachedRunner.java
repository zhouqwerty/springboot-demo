package com.qwerty.study.springbootdemo.config.memcached;

import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;

@Component
public class MemcachedRunner implements CommandLineRunner{
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private  MemcachedConfig memcachedConfig;

    private MemcachedClient client = null;
    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcachedConfig.getIp(),memcachedConfig.getPort()));
        } catch (IOException e) {
            logger.error("init MemcachedClient failed ",e);
        }
    }

    public MemcachedClient getClient() {
        return client;
    }
}
