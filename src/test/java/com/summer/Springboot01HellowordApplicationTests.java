package com.summer;

import com.summer.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.xml.ws.Action;

@SpringBootTest
class Springboot01HellowordApplicationTests {
//    @Resource(name = "userDog")
    @Autowired
    User user;

    @Test
    void contextLoads() {
        System.out.println( user);
    }

}
