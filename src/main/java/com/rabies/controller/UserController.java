package com.rabies.controller;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    // 这个接口用于实现：向User表中添加数据
    @CrossOrigin
    @PostMapping("/save")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    // 这个接口用于实现：修改User表中某条数据
    @CrossOrigin
    @PostMapping("/mod")
    public boolean modUser(@RequestBody User user){
        return userService.modUser(user);
    }

    @CrossOrigin
    @PostMapping("/modAuthority")
    public boolean modUserAuthority(@RequestBody User user){
        return userService.modUserAuthority(user);
    }

    // 这个接口用于实现：删除User表中的某条数据
    @CrossOrigin
    @GetMapping("/del")
    public boolean delUser(String username){
        return userService.delUser(username);
    }

    // 分页查询方法
    @CrossOrigin  // 允许进行跨域请求
    @GetMapping("/listPage")  // 定义了一个Get请求接口
    public HashMap<String, Object> getUserList(  // 该方法的返回类型是一个HashMap，用于封装分页数据
        @RequestParam(defaultValue = "1") int pageNum,  // pageNum的默认值是1  pageSize的默认值是5
        @RequestParam(defaultValue = "5") int pageSize,
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String country){
        // 启动分页功能
        PageHelper.startPage(pageNum, pageSize);
        // 查询用户列表（条件查询:username、country）
        List<User> users = userService.listByUsernameAndCountry(username, country);
        // PageInfo是PageHelper提供的工具类，在这里用于封装users的信息
        PageInfo<User> pageInfo = new PageInfo<>(users);
        // 创建了一个空的HashMap，用于封装返回给前端的数据
        HashMap<String, Object> result = new HashMap<>();
        // 把分页后的用户列表存入result中的data键中(这部分数据用于渲染表格)
        result.put("data", pageInfo.getList());
        // 把用户总记录数存入result中的total键中(这部分数据用来计算页数)
        result.put("total", pageInfo.getTotal());
        return result;
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
