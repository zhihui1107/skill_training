package com.example.skill_training.mapper;

import com.example.skill_training.entity.Flow;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowMapper {
    @Select("select * from tec_flow where id=#{id} and del_flag=0")
    Flow selectById(String id);
}
