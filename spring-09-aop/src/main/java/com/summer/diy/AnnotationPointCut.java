package com.summer.diy;

//使用注解方式实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.summer.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("===========annotation方法执行前========");
    }

    @After("execution(* com.summer.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("===========annotation方法执行后========");
    }

    @Around("execution(* com.summer.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
    }
}
