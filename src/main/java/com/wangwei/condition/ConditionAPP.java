package com.wangwei.condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Profile;

import java.util.Observable;
import java.util.Properties;
import java.util.Set;

/**
 * Created by wangwei on 2018/1/1.
 */
@SpringBootApplication
public class ConditionAPP {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionAPP.class, args);

//        Properties properties = System.getProperties();
//        Set<Object> keySet = properties.keySet();
//        for(Object key : keySet){
//            Object value = properties.get(key);
//            System.out.println(key+"---"+value);
//        }
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(context.getBeansOfType(EncodingConvert.class));
        System.out.println(context.getBeansOfType(TestPojo.class));

        context.close();
    }
}
