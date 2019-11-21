package com.wangwei.model;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * Created by wangwei on 2018/1/1.
 */
@SpringBootConfiguration
public class MyConfig {

    @Bean
    public MyRun createMyRun(){
        System.out.println("====default MyRun===");
        return new MyRun();
    }

    @Bean
    @Profile("dev")//只有在“dev”环境下的配置文件生效时，才会装配这个bean
    public MyRun createMyRunDev(){
        System.out.println("====dev===");
        return new MyRun();
    }

    @Bean
    @Profile("test")//只有在“test”环境下的配置文件生效时，才会装配这个bean
    public MyRun createMyRunTest(){
        System.out.println("====test===");
        return new MyRun();
    }
}
