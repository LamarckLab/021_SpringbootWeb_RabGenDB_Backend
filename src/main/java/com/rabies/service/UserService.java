package com.rabies.service;

import com.rabies.pojo.User;

import java.util.List;

public interface UserService {

    // 该接口用于实现: 将User表中的所有用户全部列出来
    List<User> listUsers();

    boolean addUser(User user);

    User getUserByUsername(String username);

    List<User> listByUsernameAndCountry(String username, String country);



    boolean modUser(User user);

    boolean delUser(String username);

    boolean modUserAuthority(User user);
}
