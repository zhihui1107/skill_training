package com.example.skill_training.service.impl;

import com.example.skill_training.entity.User;
import com.example.skill_training.mapper.UserMapper;
import com.example.skill_training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User Login(String login_name) {
        return userMapper.Login(login_name);
    }
}
