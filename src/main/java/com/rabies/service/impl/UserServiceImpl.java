package com.rabies.service.impl;

import com.rabies.mapper.UserMapper;
import com.rabies.pojo.User;
import com.rabies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    // 该接口用于实现: 将User表中的所有用户全部列出来
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    @Override
    // 该接口用于实现: 向User表中添加一个用户
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    // 该接口用于实现: 更改User表中某个用户的信息
    public boolean modUser(User user) {
        return userMapper.modUser(user);
    }

    @Override
    // 该接口用于实现: 删除User表中的某个用户
    public boolean delUser(String username) {
        return userMapper.delUser(username);
    }

    @Override
    // 该接口用于实现: 修改User表中某个用户的权限(role)
    public boolean modUserAuthority(User user) {
        return userMapper.modeUserAuthority(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> listByUsernameAndCountry(String username, String country) {
        if ((username != null && !username.isEmpty()) && (country != null && !country.isEmpty())) {
            return userMapper.findByUserNameAndCountry(username, country);
        }
        else if(username != null && !username.isEmpty()) {
            return userMapper.findByUserName(username);
        }
        else if(country != null && !country.isEmpty()) {
            return userMapper.findByCountry(country);
        }
        else{
            return userMapper.listUsers();
        }
    }




}
