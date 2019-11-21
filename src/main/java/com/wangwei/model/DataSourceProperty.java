package com.wangwei.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2017/12/31.
 */
@Component
@ConfigurationProperties()
public class DataSourceProperty {
    private String url;
    private String driverClassName;
    private String user;
    private String pwd;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void show(){
        System.out.println("--ds.url:"+url+",ds.driverClassName:"+driverClassName+",ds.user:"+user+",ds.pwd:"+pwd);
    }
}
