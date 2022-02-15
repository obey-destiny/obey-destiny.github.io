package com.haha.dao;

import com.haha.entity.User;

public interface UserDao {
    User findByUserName(String username);

    void save(User user);
}
