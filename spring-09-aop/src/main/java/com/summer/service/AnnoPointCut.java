package com.summer.service;

import com.summer.config.AopConfig;
import com.summer.config.LogConfig;
import com.summer.log.AfterLog;
import com.summer.log.AopLog;
import com.summer.log.Log;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
public class AnnoPointCut {
    ApplicationContext context = new  AnnotationConfigApplicationContext(LogConfig.class);
    AopLog log = context.getBean("aopLog", AopLog.class);

    @Before("execution(* com.summer.service.UserServiceImpl.*(..))")
    public void before(){
        log.beforeLog();
    }

    @After("execution(* com.summer.service.UserServiceImpl.*(..))")
    public void after(){
        log.afterLog();
    }

}
