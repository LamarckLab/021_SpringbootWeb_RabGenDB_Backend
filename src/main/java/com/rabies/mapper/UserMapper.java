package com.rabies.mapper;

import com.rabies.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from rabies.user")
    List<User> listUsers();
}
