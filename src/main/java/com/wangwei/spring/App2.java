package com.wangwei.spring;

import com.wangwei.model.MyRun;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2017/12/30.
 */
@SpringBootApplication
public class App2 {
    @Bean
    public User createUser(){
        return new User();
    }
}
