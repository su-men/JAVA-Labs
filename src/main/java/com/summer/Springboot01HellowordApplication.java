package com.summer;

import com.summer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class Springboot01HellowordApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01HellowordApplication.class, args);
    }

}
