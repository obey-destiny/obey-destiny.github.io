package com.haha.entity;

public class User {
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private Boolean gender;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public User() {
    }

    public User(Integer id, String username, String realname, String password, Boolean gender) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.gender = gender;
    }

    public User(String realname) {
        this.realname = realname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
