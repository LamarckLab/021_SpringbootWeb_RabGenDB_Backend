package com.rabies.pojo;

// User实体类
public class User {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private String email;
    private String country;
    private Integer role;  // 0超级管理员  1管理员  2普通用户

    // User实体类无参构造方法
    public User() {
    }

    // User实体类全参构造方法
    public User(Integer id, String username, String password, String telephone, String email, String country, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
        this.country = country;
        this.role = role;
    }

    // User实体类的get set方法
    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public Integer getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    // User实体类的toString方法
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", role=" + role +
                '}';
    }
}
