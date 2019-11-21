package com.wangwei.enable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2018/1/1.
 */
@ConfigurationProperties(prefix = "enable")
@Component
public class TomcatInfo {

    private String port;
    private String addr;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "TomcatInfo{" +
                "port='" + port + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
