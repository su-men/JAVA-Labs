package com.summer.service;

import com.summer.dao.UserDao;

public interface UserService {

    void setUserDao(UserDao userDao);
    void getUser();
}
