package com.wangwei.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * springboot的默认配置文件名称：application.properties或者application.yml.
 * 配置文件的默认路径：1,classpath 2,classpath:config/ 3,file:/ 4,file:/config
 */
@Component
public class PropertyConfig {
    @Value("${custom.name}")
    private String customName;
    @Value("${custom.num}")
    private Integer customNum;
    @Value("${trueword}")
    private String trueWord;
    /**
     * "@Value" 可以配置默认值。如果获取的属性名在配置文件中找不到，此时可以通过":默认值"的方式指定一个默认值。
     * 这样就可以获取到这个属性的值了。如果，配置文件中已经有这个属性名，配置文件中的值优先级要高于此处配置的默认值。
     */
    @Value("${tomcat.port:8090}")
    private String tomcatPort;

    @Autowired
    private Environment environment;

    public void show(){
        System.out.println(environment.getProperty("server.address")+"-----"+customName
        +"----"+customNum);
        System.out.println("===="+trueWord);
        System.out.println("========"+tomcatPort);
    }
}
