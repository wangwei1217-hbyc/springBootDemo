package com.wangwei.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @PropertySource 注解加载外部配置文件
 * 也可以使用
 * @PropertySources 加载多个配置文件
 */
@Configuration
@PropertySource(value = {"classpath:jdbc.properties","file:/E:/temp/mysql.properties"})
//@PropertySources(value = {@PropertySource("classpath:jdbc.properties"),@PropertySource("file:/E:/temp/mysql.properties")})
public class FileConfig {
}
