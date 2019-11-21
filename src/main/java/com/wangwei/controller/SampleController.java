package com.wangwei.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangwei on 2017/12/2.
 */
@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/home")
    @ResponseBody
    public String home(){
        return "Hello World";
    }

    public static void main(String[] args) {
        /*
        SpringApplication.run():第一个参数指定配置类
         */
        ConfigurableApplicationContext context = SpringApplication.run(SampleController.class, args);
    }
}
