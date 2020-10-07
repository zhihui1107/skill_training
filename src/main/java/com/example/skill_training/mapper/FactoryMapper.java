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
    @Select("select bas_factory.*,bas_enterprise.* from bas_factory left join bas_enterprise on bas_factory.enterprise_id=bas_enterprise.id")
    List<Factory> allFactory();

    @Select("select * from bas_factory where factoryName=#{factoryName}")
    Factory oneFactory(String enterName);

    @Select("select * from bas_factory where id=#{id}")
    Factory selectById(String id);

    @Select("select * from bas_factory where id<>#{id}")
    List<Factory> otherFactory(String id);

    @Insert("insert into bas_factory(id,factoryName,factoryBuildDate,factoryAddress,factoryPhone,factoryECode,factoryBuildM,enterprise_id,create_date) " +
            "values(#{id},#{factoryName},#{factoryBuildDate},#{factoryAddress},#{factoryPhone},#{factoryECode},#{factoryBuildM},#{enterprise_id},#{create_date})")
    boolean insertFactory(Factory factory);

    @Update("update bas_factory set factoryName=#{factoryName},factoryBuildDate=#{factoryBuildDate},factoryAddress=#{factoryAddress}," +
            "factoryPhone=#{factoryPhone},factoryECode=#{factoryECode},factoryBuildM=#{factoryBuildM},enterprise_id=#{enterprise_id}," +
            "update_date=#{update_date} where id=#{id}")
    boolean updateFactory(Factory factory);

    @Delete("delete from bas_factory where factoryName=#{factoryName}")
    boolean deleteFactory(String factoryName);
}
