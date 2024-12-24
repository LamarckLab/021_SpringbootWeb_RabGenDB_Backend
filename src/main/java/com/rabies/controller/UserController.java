package com.rabies.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.rabies.pojo.User;
import com.rabies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.listUsers();
    }

    // 接收前端传递的用户登录信息并验证
    @CrossOrigin  // 运行进行跨域请求
    @PostMapping("/login")  // 当前端向/login发送一个POST请求时，会调用这个方法
    public HashMap<String, Object> login(@RequestBody User loginRequest) {  // 返回值是一个HashMap, 键是String, 值是Object, 前端请求被解析为一个User对象
        HashMap<String, Object> result = new HashMap<>();  // 创建了一个空的HashMap, 用于存储返回给前端的结果
        User user = userService.getUserByUsername(loginRequest.getUsername());  // 根据前端提供的no, 查询该User的全部信息
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {  // 如果该用户存在, 且数据库中的密码等于前端提供的密码
            result.put("success", true);  // 这里的result.put用于在返回数据中添加一对键值对
            result.put("message", "Login successful");
            result.put("user", user);
        } else {
            result.put("success", false);
            result.put("message", "Incorrect ID or Password");
        }
        return result;  // 将result这个HashMap返回给前端
    }

}
