package com.wangwei.spring;

import com.wangwei.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2017/12/30.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wangwei"})
public class AppClient {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(AppClient.class, args);
        SpringApplication springApplication = new SpringApplication(AppClient.class);

        /*
        读取特定环境的配置文件
        此处设置dev，则会读取classpath下文件名为application-dev.properties或者application-dev.yml文件

        或者在启动时，指定arguments：--spring.profiles.active=dev.
        或者在application.properties默认配置文件中添加属性：--spring.profiles.active=dev
         */
        //可以设置多个,用","隔开
//        springApplication.setAdditionalProfiles("test","dev");
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(context.getEnvironment().getProperty("server.port"));
        context.getBean(PropertyConfig.class).show();
        context.getBean(MySqlDataSourceInfo.class).show();
        context.getBean(PrefixProperty.class).show();
        context.getBean(DataSourceProperty.class).show();

        System.out.println(context.getEnvironment().getProperty("mysql.test.url"));
        System.out.println("动态加载特定配置文件中的url:"+context.getEnvironment().getProperty("url"));
        System.out.println(context.getBeansOfType(MyRun.class));
        context.close();

    }
}
