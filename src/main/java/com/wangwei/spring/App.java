package com.wangwei.spring;

import com.wangwei.model.MyRun;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashSet;

/**
 * @SpringBootApplication注解会默认扫描当前包下的类，比如User类
 * Created by wangwei on 2017/12/30.
 */
@SpringBootApplication
public class App {

    @Bean
    public MyRun createMyRun(){
        return new MyRun();
    }

    public static void main(String[] args) {
        /*
        SpringApplication.run(App.class, args);
        1,第一个参数：App.class,指定配置类。springboot会自动将指定的类转为配置类。此时类上注解@SpringBootConfiguration可以省略。
         */
//        ConfigurableApplicationContext context = SpringApplication.run(App2.class, args);
        SpringApplication springApplication = new SpringApplication();
        HashSet<Object> sources = new HashSet<Object>();
        sources.add(App.class);
        springApplication.setSources(sources);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(context.getBean(User.class));
        System.out.println(context.getBeansOfType(MyRun.class));
    }
}
