package com.example.skill_training.mapper;

import com.example.skill_training.entity.Material;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialMapper {
    @Select("select sum(quantity) as sum from material where del_flag=0 and mType=#{mType}")
    Material findSum(Material material);

    @Select("select * from material where del_flag=0 and mType=#{mType} order by purchaseDate")
    List<Material> findList(Material material);

    @Update("update material set quantity=#{quantity} where id=#{id}")
    boolean saveMaterial(Material material);
}
