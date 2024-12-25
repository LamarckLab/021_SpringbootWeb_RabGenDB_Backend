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
    public List<User> listUsers() {
        return userMapper.listUsers();
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

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean modUser(User user) {
        return userMapper.modUser(user);
    }

    @Override
    public boolean delUser(String username) {
        return userMapper.delUser(username);
    }

    @Override
    public boolean modUserAuthority(User user) {
        return userMapper.modeUserAuthority(user);
    }
}
