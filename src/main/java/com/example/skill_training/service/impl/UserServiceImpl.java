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
    private UserMapper userMapper;
    @Override
    public List<User> getAll(){
        return userMapper.allUser();
    }
}
