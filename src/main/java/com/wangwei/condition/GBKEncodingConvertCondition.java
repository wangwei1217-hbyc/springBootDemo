package com.wangwei.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2018/1/1.
 */
@Component
public class GBKEncodingConvertCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String fileEncoding = System.getProperty("file.encoding");
        if("gbk".equals(fileEncoding.toLowerCase())){
            return true;
        }
        return false;
    }
}
