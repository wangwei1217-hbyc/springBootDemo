package com.wangwei.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/12/31.
 */
@Component
public class MySqlDataSourceInfo {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driverName}")
    private String driverName;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    public void show(){
        System.out.println("***** url:"+url+",driverName:"+driverName+",username:"+userName+",password:"+password);
    }

}
