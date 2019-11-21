package com.wangwei.condition;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * Condition接口：基于条件的自动配置，自定义条件对象需要实现这个接口，重写接口当中的matches()方法。
 * 根据自己的业务逻辑来判断何时返回true或false.  true--代表条件生效，false--代表条件不生效。通常跟@Conditional结合使用。
 *
 * <>@Conditional</>：用于指定特定的条件对象。意为当指定的条件对象生效时才装配Bean.
 * 条件对象可以指定多个，意为当所有的条件对象都返回true时才进行装配Bean.
 *
 * 可以作用在方法上，此时仅对该方法有效；也可以作用在类上，此时对该类中所有方法有效。
 *
 */
@SpringBootConfiguration
//@Conditional(value = {GBKEncodingConvertCondition.class,UTF8EncodingConvertCondition.class})
public class ConditionConfig {

    /**
     *只有当实现了Condition接口的UTF8EncodingConvertCondition类重写的方法matches()返回true时，
     * 才会装配这个bean
     * @return
     */
    @Bean
    @Conditional(value = {UTF8EncodingConvertCondition.class})
    public EncodingConvert createUTF8EncodingConvert(){
        return new UTF8EncodingConvert();
    }

    /**
     *只有当实现了Condition接口的GBKEncodingConvertCondition类重写的方法matches()返回true时，
     * 才会装配这个bean
     * @return
     */
    @Bean
    @Conditional(value = {GBKEncodingConvertCondition.class})
    public EncodingConvert createGBKEncodingConvert(){
        return new GBKEncodingConvert();
    }


    //-----------------SpringBoot自带的一些Condition

    /**
     * <>@ConditionalOnProperty</>:当配置文件中存在某个属性，且属性的值为指定的value时，进行装配Bean
     * @return
     */
    @Bean
    @ConditionalOnProperty(name = "condition.flag",havingValue = "true")
    public TestPojo createTestPojoOnProperty(){
        return new TestPojo();
    }

    /**
     * <>@ConditionalOnClass(name = "com.wangwei.User")</>
     * 当classpath下存在指定的类时，才进行装配Bean
     * @return
     */
    @Bean
    @ConditionalOnClass(name = "com.wangwei.condition.GirlFriend")
    public TestPojo createTestPojoOnClass(){
        return new TestPojo();
    }

    /**
     * <>@ConditionalOnBean(value = {BoyFriend.class})</>
     * 当在Spring容器当中注册有指定的Bean时，才进行装配Beam
     * @return
     */
    @Bean
    @ConditionalOnBean(value = {BoyFriend.class})
    public TestPojo createTestPojoOnBean(){
        return new TestPojo();
    }

    /**
     * <>@ConditionalOnJava(range = ConditionalOnJava.Range.OLDER_THAN,value = ConditionalOnJava.JavaVersion.NINE)</>
     * 当JVM版本满足条件时，进行装配Bean.
     * range-默认：Range.EQUAL_OR_NEWER 大于等于;Range.OLDER_THAN 小于
     * value-JVM的版本号,详见JavaVersion枚举类
     * @return
     */
    @Bean
    @ConditionalOnJava(range = ConditionalOnJava.Range.OLDER_THAN,value = ConditionalOnJava.JavaVersion.NINE)
    public TestPojo createTestPojoOnJava(){
        return new TestPojo();
    }
}
