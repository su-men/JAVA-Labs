package com.summer.config;

import com.summer.log.AopLog;
import com.summer.service.AnnoPointCut;
import com.summer.service.UserServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.summer.service")
public class AopConfig {
    @Bean
    public UserServiceImpl userService(){
        return new UserServiceImpl();
    }

    @Bean
    public AnnoPointCut pointCut(){
        return new AnnoPointCut();
    }

}
