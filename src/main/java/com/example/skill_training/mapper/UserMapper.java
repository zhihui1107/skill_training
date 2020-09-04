package com.example.skill_training.mapper;

import com.example.skill_training.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("select * from sys_user;")
    List<User> allUser();
}
