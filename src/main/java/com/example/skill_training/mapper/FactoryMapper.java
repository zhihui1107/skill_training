package com.example.skill_training.mapper;

import com.example.skill_training.entity.Factory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FactoryMapper {
    @Select("select * from bas_factory left join bas_enterprise on bas_factory.enterprise_id=bas_enterprise.id " +
            "where bas_factory.del_flag=0 and bas_enterprise.del_flag=0")
    List<Factory> allFactory();

    @Select("select * from bas_factory where factoryName=#{factoryName} and del_flag=0")
    Factory oneFactory(String factoryName);

    @Select("select * from bas_factory where id=#{id} and del_flag=0")
    Factory selectById(String id);

    @Select("select * from bas_factory where id<>#{id} and del_flag=0")
    List<Factory> otherFactory(String id);

    @Insert("insert into bas_factory(id,factoryName,factoryBuildDate,factoryAddress,factoryPhone,factoryECode," +
            "factoryBuildM,enterprise_id,del_flag,remarks,create_by,create_date,update_by,update_date) " +
            "values(#{id},#{factoryName},#{factoryBuildDate},#{factoryAddress},#{factoryPhone},#{factoryECode}," +
            "#{factoryBuildM},#{enterprise_id},#{del_flag},#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertFactory(Factory factory);

    @Update("update bas_factory set factoryName=#{factoryName},factoryBuildDate=#{factoryBuildDate},factoryAddress=#{factoryAddress}," +
            "factoryPhone=#{factoryPhone},factoryECode=#{factoryECode},factoryBuildM=#{factoryBuildM},enterprise_id=#{enterprise_id}," +
            "del_flag=#{del_flag},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateFactory(Factory factory);

    @Update("update bas_factory set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteFactory(Factory factory);
}
