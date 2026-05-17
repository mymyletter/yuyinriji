package com.example.yuyinriji.service;

import com.example.yuyinriji.entity.User;
public interface UserService {
    boolean register(String username, String password);
    User login(String username, String password);
}