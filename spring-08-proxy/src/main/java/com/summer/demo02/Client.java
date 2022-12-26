package com.summer.demo02;


public class Client {
    public static void main(String[] args){
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);

        UserService proxy = (UserService) pih.getProxy();

        proxy.add();

        Object ob = new Object();


    }
}
