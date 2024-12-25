package com.rabies.service;

import com.rabies.pojo.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUserByUsername(String username);

    List<User> listByUsernameAndCountry(String username, String country);
}
