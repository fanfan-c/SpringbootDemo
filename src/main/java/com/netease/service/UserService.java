package com.netease.service;

import com.netease.dao.UserRepository;
import com.netease.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {//User业务逻辑
    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String name) {
        User user = null; //null

        try {
            user = userRepository.findByUserName(name);
        } catch (Exception e) {
        }

        return user;
    }
}
