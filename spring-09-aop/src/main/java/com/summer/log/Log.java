package com.summer.log;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class Log implements MethodBeforeAdvice {

    //method 被代理的对象所拥有的方法
    // args 方法的参数
    // target 被代理的对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[debug]" + target.getClass().getName() + "的" + method.getName() + "的方法即将被执行");
    }

}
