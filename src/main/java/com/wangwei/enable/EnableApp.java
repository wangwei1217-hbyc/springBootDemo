package com.wangwei.enable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2018/1/1.
 */
//@SpringBootApplication
@EnableAutoConfiguration
//@SpringBootConfiguration
//@EnableConfigurationProperties
@ComponentScan
public class EnableApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(EnableApp.class, args);
        System.out.println(context.getBeansOfType(TomcatInfo.class));

        context.close();
    }
}
