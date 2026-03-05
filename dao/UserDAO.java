package com.resume.dao;

import com.resume.bean.User;

public interface UserDAO {

    boolean register(User user);

    User login(String username, String password);

}