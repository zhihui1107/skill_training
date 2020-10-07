package com.example.skill_training.mapper;

import com.example.skill_training.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    @Select("select * from bas_product where id=#{id} and del_flag=0")
    Product selectById(String id);

    @Select("select * from bas_product where productName=#{productName} and del_flag=0")
    Product selectByProductName(String productName);
}
