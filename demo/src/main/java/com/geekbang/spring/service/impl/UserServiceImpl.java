package com.geekbang.spring.service.impl;

import com.geekbang.spring.dao.UserDao;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class UserServiceImpl {

    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    private UserDao userDao;

    public UserServiceImpl() {}

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public static UserServiceImpl createInstance() {
        return userServiceImpl;
    }
}
