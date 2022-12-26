package com.summer.service;

import org.springframework.stereotype.Component;

public class UserServiceImpl implements  UserService {

    @Override
    public void add(){
        System.out.println("这是一个add操作!");
    }

    @Override
    public void delete(){
        System.out.println("这是一个delete操作!");
    }

    @Override
    public void update(){
        System.out.println("这是一个update操作!");
    }

    @Override
    public void query(){
        System.out.println("这是一个query操作!");
    }
}
