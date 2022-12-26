package com.summer.config;

import com.summer.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
 *  @Configuration也会被注册到Spring中，因为它本身就是一个@Component,
 *  @Configuration代表这是一个配置类，和beans.xml一样
 */
@Configuration
@ComponentScan("com.summer.pojo")
public class UserConfig {

    //注册一个bean 等价于beans.xml里的<bean>标签
    //这个方法的名字，等价于id属性
    //这个方法的返回值，等价于class属性
    //<bean id="user1"  class="com.summer.pojo.User" scope="prototype">
    @Bean
    @Scope("prototype")
    public User user1(){
        return new User();
    }

    @Bean
    public User user2(){
        User user =  new User();
        user.setName("dummer");
        return  user;
    }
}
