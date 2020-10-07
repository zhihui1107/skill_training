package com.example.skill_training.mapper;

import com.example.skill_training.entity.Line;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineMapper {
    @Select("select * from bas_line left join bas_workshop on bas_line.workshop_id=bas_workshop.id " +
            "where bas_line.del_flag=0 and bas_workshop.del_flag=0")
    List<Line> allLine();

    @Select("select * from bas_line where lineName=#{lineName} and del_flag=0")
    Line oneLine(String enterName);

    @Select("select * from bas_line where id=#{id} and del_flag=0")
    Line selectById(String id);

    @Select("select * from bas_line where id<>#{id} and del_flag=0")
    List<Line> otherLine(String id);

    @Select("select * from bas_line where lineNumber=#{lineNumber} and del_flag=0")
    Line oneLineName(String lineNumber);

    @Insert("insert into bas_line(id,lineName,lineNumber,lineMaster,lineDescription,workshop_id,del_flag,remarks," +
            "create_by,create_date,update_by,update_date) " +
            "values(#{id},#{lineName},#{lineNumber},#{lineMaster},#{lineDescription},#{workshop_id},#{del_flag}," +
            "#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertLine(Line line);

    @Update("update bas_line set lineName=#{lineName},lineNumber=#{lineNumber},lineMaster=#{lineMaster}," +
            "lineDescription=#{lineDescription},workshop_id=#{workshop_id},del_flag=#{del_flag}," +
            "remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateLine(Line line);

    @Update("update bas_line set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteLine(Line line);
}
