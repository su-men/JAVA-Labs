package com.summer.dao;

public class UserDaoMysqlImpl implements UserDao{

    public UserDaoMysqlImpl(){
        System.out.println("userDaoMysqlImpl create");
    }

    @Override
    public void getUser(){
        System.out.println("mysql:获取用户数据");
    }
}
