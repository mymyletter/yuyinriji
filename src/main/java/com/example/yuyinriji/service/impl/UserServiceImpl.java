package com.example.yuyinriji.service.impl;

import com.example.yuyinriji.entity.User;
import com.example.yuyinriji.mapper.UserMapper;
import com.example.yuyinriji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean register(String username, String password) {
        if(userMapper.selectByUsername(username) != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.insert(user) > 0;
    }
    @Override
    public User login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null || !password.equals(user.getPassword())) {
            return null;
        }
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set("LOGIN:" + token, String.valueOf(user.getId()), 30, TimeUnit.MINUTES);
        return user;
    }
}