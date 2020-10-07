package com.example.skill_training.mapper;

import com.example.skill_training.entity.Bom;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BomMapper {
    @Select("select * from bas_bom where product_id=#{product_id} and del_flag=0")
    Bom selectByProduct_Id(String product_id);

}
