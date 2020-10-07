package com.example.skill_training.mapper;

import com.example.skill_training.entity.Dictionary;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DictionaryMapper {
    @Select("select label,value from sys_dict where type='equip_spec';")
    List<Dictionary> GetAllSpecBytype();

    @Select("select label,value from sys_dict where type='equip_type';")
    List<Dictionary> GetAllTypeBytype();
}
