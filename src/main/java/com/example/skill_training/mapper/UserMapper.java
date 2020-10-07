package com.example.skill_training.mapper;

import com.example.skill_training.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    /*根据用户名查询用户信息*/
    @Select("select * from sys_user where login_name=#{login_name};")
    User Login(String login_name);
}
