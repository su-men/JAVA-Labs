package com.summer.dao;

public class UserDaoSqlServerImpl implements UserDao{
    @Override
    public void getUser(){
        System.out.println("SqlServer: 获取用户数据");
    }
}
