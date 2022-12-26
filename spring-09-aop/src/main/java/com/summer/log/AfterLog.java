package com.summer.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AfterLog implements AfterReturningAdvice {


    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

        System.out.println("[debug]" + target.getClass().getName() + "的" + method.getName() + "的方法已经被执行了");
        //System.out.println("[debug]" + method.getName() + "的放回结果为：" + returnValue.getClass().getName());
    }

}
