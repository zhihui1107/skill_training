package com.example.skill_training.mapper;

import com.example.skill_training.entity.Dictionary;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD

@Repository
public interface DictionaryMapper {
    @Select("select * from sys_dict where type=#{type}")
    List<Dictionary> selectType(String type);

    @Select("select * from sys_dict where type=#{type} and value=#{value}")
    Dictionary selectOneType(String type,String value);

    @Select("select * from sys_dict where type=#{type} and label=#{label}")
    Dictionary selectOneValue(String type,String label);

    @Select("select * from sys_dict where type=#{type} and value<>#{value}")
    List<Dictionary> otherType(String type,String value);
=======
@Repository
public interface DictionaryMapper {
    @Select("select label,value from sys_dict where type='equip_spec';")
    List<Dictionary> GetAllSpecBytype();

    @Select("select label,value from sys_dict where type='equip_type';")
    List<Dictionary> GetAllTypeBytype();
>>>>>>> origin/master
}
