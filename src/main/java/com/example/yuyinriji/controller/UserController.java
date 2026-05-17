package com.example.yuyinriji.controller;
import com.example.yuyinriji.entity.User;
import com.example.yuyinriji.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        boolean ok = userService.register(username, password);
        return ok ? "注册成功" : "用户名已存在";
    }
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password) {
        User user = userService.login(username, password);
        Map<String, Object> result = new HashMap<>();
        if (user != null) {
            result.put("success", true);
            result.put("userId", user.getId());
            result.put("username", user.getUsername());
            result.put("message", "登录成功");
        } else {
            result.put("success", false);
            result.put("message", "账号或密码错误");
        }
        return result;
    }
}