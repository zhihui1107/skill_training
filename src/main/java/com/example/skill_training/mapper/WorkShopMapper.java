package com.example.skill_training.mapper;

import com.example.skill_training.entity.WorkShop;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkShopMapper {
    @Select("select bas_workshop.*,bas_factory.* from bas_workshop left join bas_factory on bas_workshop.factory_id=bas_factory.id")
    List<WorkShop> allWorkShop();

    @Select("select * from bas_workshop where shopName=#{shopName}")
    WorkShop oneWorkShop(String shopName);

    @Select("select * from bas_workshop where id=#{id}")
    WorkShop selectById(String id);

    @Select("select * from bas_workshop where id<>#{id}")
    List<WorkShop> otherWorkShop(String id);

    @Insert("insert into bas_workshop(id,shopName,shopNo,master,description,factory_id,create_date) " +
            "values(#{id},#{shopName},#{shopNo},#{master},#{description},#{factory_id},#{create_date})")
    boolean insertWorkShop(WorkShop workShop);

    @Update("update bas_workshop set shopName=#{shopName},shopNo=#{shopNo},master=#{master}," +
            "description=#{description},factory_id=#{factory_id},update_date=#{update_date} where id=#{id}")
    boolean updateWorkShop(WorkShop workShop);

    @Delete("delete from bas_workshop where shopName=#{shopName}")
    boolean deleteWorkShop(String shopName);
}
