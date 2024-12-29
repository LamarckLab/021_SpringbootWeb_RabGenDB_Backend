package com.rabies.service;

import com.rabies.pojo.User;

import java.util.List;

public interface UserService {

    // 该接口用于实现: 将User表中的所有用户全部列出来
    List<User> listUsers();

    // 该接口用于实现: 向User表中添加一个用户
    boolean addUser(User user);

    // 该接口用于实现: 更改User表中某个用户的信息
    boolean modUser(User user);

    // 该接口用于实现: 删除User表中的某个用户
    boolean delUser(String username);

    // 该接口用于实现: 修改User表中某个用户的权限(role)
    boolean modUserAuthority(User user);

    // 该接口用于实现: User表的分页查询
    List<User> listByUsernameAndCountry(String username, String country);

    // 该接口用于实现: 根据username得到整个user对象
    User getUserByUsername(String username);








}
