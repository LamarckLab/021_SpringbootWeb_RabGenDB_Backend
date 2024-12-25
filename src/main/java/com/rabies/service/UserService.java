package com.rabies.service;

import com.rabies.pojo.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUserByUsername(String username);

    List<User> listByUsernameAndCountry(String username, String country);

    boolean addUser(User user);

    boolean modUser(User user);

    boolean delUser(String username);

    boolean modUserAuthority(User user);
}
