package com.rabies.mapper;

import com.rabies.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 该方法用于实现: 将User表中的所有用户全部列出来
    @Select("select * from rabies.user")
    List<User> listUsers();

    @Select("select * from rabies.user where username=#{username}")
    User getUserByUsername(String username);

    @Select("select * from rabies.user where username like CONCAT('%', #{username}, '%')")
    List<User> findByUserName(String username);

    @Select("select * from rabies.user where country like CONCAT('%', #{country}, '%')")
    List<User> findByCountry(String country);

    @Select("select * from rabies.user where username like CONCAT('%', #{username}, '%') and country like CONCAT('%', #{country}, '%')")
    List<User> findByUserNameAndCountry(String username, String country);

    @Insert("insert into rabies.user (username, password, telephone, email, country, role) values (#{username}, #{password}, #{telephone}, #{email} ,#{country} ,#{role})")
    boolean addUser(User user);

    @Update("update rabies.user set password=#{password}, telephone=#{telephone}, email=#{email}, country=#{country} where username=#{username}")
    boolean modUser(User user);

    @Delete("delete from rabies.user where username=#{username}")
    boolean delUser(String username);

    @Update("update rabies.user set role=#{role} where username=#{username}")
    boolean modeUserAuthority(User user);
}
