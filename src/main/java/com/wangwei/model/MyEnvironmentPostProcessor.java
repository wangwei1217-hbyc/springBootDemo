package com.wangwei.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 可以在启动时动态装配一些配置文件。
 * 注意的是：在classpath路径下需要有 META-INF/spring.factories文件，用来注册我们程序实现了的EnvironmentPostProcessor接口的实现类。
 * spring.factories文件中写法：
 *   org.springframework.boot.env.EnvironmentPostProcessor=com.wangwei.model.MyEnvironmentPostProcessor
 *
 * 这样注册之后，才会生效，才能获取到动态加载配置文件中的属性值。
 */
@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {

    public void postProcessEnvironment(ConfigurableEnvironment configurableEnvironment, SpringApplication springApplication) {
        try {
            FileInputStream fis = new FileInputStream("E:/temp/mysql-test.properties");
            Properties prop = new Properties();
            prop.load(fis);
            PropertiesPropertySource source = new PropertiesPropertySource("my",prop);
            configurableEnvironment.getPropertySources().addLast(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
