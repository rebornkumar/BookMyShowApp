package com.learn.BookMyShow.service;

import com.learn.BookMyShow.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    User findUserByUsername(String userName);
    void saveUser(User user);
}
