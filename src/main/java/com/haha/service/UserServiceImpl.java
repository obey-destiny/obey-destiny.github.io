package com.haha.service;

import com.haha.dao.UserDao;
import com.haha.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void register(User user) {
        User userDB = userDao.findByUserName(user.getUsername());
        if (!ObjectUtils.isEmpty(userDB)) throw new RuntimeException("用户名已存在！");
        String newPassword = DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8));
        user.setPassword(newPassword);
        userDao.save(user);
    }
}
