package com.wangwei.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 注解加载配置文件,并自动映射到属性值（实体bean属性和配置文件属性名相同(不含前缀)）。映射的属性需要get、set方法
 */
@Component
@ConfigurationProperties(prefix = "a")
public class PrefixProperty {
    private String id;
    private String desc;
    //映射List集合和数组都可以
    /*
    a.items[0]=yuwen
    a.items[1]=shuxue
    a.items[2]=yingyu
     */
    private List<String> items;

    //映射Map集合也是可以的
    /*
    a.params[yuwen]=100
    a.params[shuxue]=120
     */
    private Map<String,String> params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void show(){
        System.out.println("---a.id="+id+",a.desc="+desc+",items="+items);
        System.out.println("a.params="+params);
    }
}
