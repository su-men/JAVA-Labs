package com.summer;

import com.summer.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@Configuration
public class MyTest {
    @Resource(name = "userDog")
    User user;

    @Test
    public void test(){
        System.out.println(user);
    }
}
