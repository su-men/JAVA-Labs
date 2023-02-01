package com.summer.service;

import com.summer.dao.UserDao;
import com.summer.dao.UserDaoImpl;

public class UserServiceImpl implements  UserService{
    private UserDao userDao;

    public UserServiceImpl(){
        System.out.println("userServiceImpl create");
    }

    public void setUserDao(UserDao userDao){
       this.userDao = userDao;
    }


    public void getUser(){
        userDao.getUser();
    }
}
