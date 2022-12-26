package com.summer.config;

import com.summer.log.AfterLog;
import com.summer.log.AopLog;
import com.summer.log.Log;
import com.summer.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.summer.log")
public class LogConfig {
//    @Bean
//    public Log log(){
//        return new Log();
//    }
//
//    @Bean
//    public AfterLog afterLog(){
//        return new AfterLog();
//    }
//
    @Bean
    public AopLog aopLog(){
        return new AopLog();
    }

}
