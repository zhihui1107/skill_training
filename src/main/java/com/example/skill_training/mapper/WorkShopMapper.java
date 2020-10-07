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
    @Select("select * from bas_workshop left join bas_factory on bas_workshop.factory_id=bas_factory.id " +
            "where bas_workshop.del_flag=0 and bas_factory.del_flag=0")
    List<WorkShop> allWorkShop();

    @Select("select * from bas_workshop where shopName=#{shopName} and del_flag=0")
    WorkShop oneWorkShop(String shopName);

    @Select("select * from bas_workshop where id=#{id} and del_flag=0")
    WorkShop selectById(String id);

    @Select("select * from bas_workshop where id<>#{id} and del_flag=0")
    List<WorkShop> otherWorkShop(String id);

    @Insert("insert into bas_workshop(id,shopName,shopNo,master,description,factory_id,del_flag,remarks,create_by," +
            "create_date,update_by,update_date) " +
            "values(#{id},#{shopName},#{shopNo},#{master},#{description},#{factory_id},#{del_flag},#{remarks}," +
            "#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertWorkShop(WorkShop workShop);

    @Update("update bas_workshop set shopName=#{shopName},shopNo=#{shopNo},master=#{master},description=#{description}," +
            "factory_id=#{factory_id},del_flag=#{del_flag},remarks=#{remarks},update_date=#{update_date} where id=#{id}")
    boolean updateWorkShop(WorkShop workShop);

    @Update("update bas_workshop set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteWorkShop(WorkShop workShop);
}
