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
    @Select("select bas_line.*,bas_workshop.* from bas_line left join bas_workshop on bas_line.workshop_id=bas_workshop.id")
    List<Line> allLine();

    @Select("select * from bas_line where lineName=#{lineName}")
    Line oneLine(String enterName);

    @Select("select * from bas_line where id=#{id}")
    Line selectById(String id);

    @Select("select * from bas_line where id<>#{id}")
    List<Line> otherLine(String id);

    @Insert("insert into bas_line(id,lineName,lineNumber,lineMaster,lineDescription,workshop_id,create_date) " +
            "values(#{id},#{lineName},#{lineNumber},#{lineMaster},#{lineDescription},#{workshop_id},#{create_date})")
    boolean insertLine(Line line);

    @Update("update bas_line set lineName=#{lineName},lineNumber=#{lineNumber},lineMaster=#{lineMaster}," +
            "lineDescription=#{lineDescription},workshop_id=#{workshop_id},update_date=#{update_date} where id=#{id}")
    boolean updateLine(Line line);

    @Delete("delete from bas_line where lineName=#{lineName}")
    boolean deleteLine(String lineName);
}
