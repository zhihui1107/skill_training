package com.example.skill_training.mapper;

import com.example.skill_training.entity.WorkCell;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkCellMapper {
    @Select("select * from bas_workcell left join bas_workstationinfos on bas_workcell.station_id=bas_workstationinfos.id " +
            "where bas_workcell.del_flag=0 and bas_workstationinfos.del_flag=0")
    List<WorkCell> allWorkCell();

    @Select("select * from bas_workcell where cellName=#{cellName} and del_flag=0")
    WorkCell oneWorkCell(String cellName);

    @Select("select * from bas_workcell where id=#{id} and del_flag=0")
    WorkCell selectById(String id);

    @Select("select * from bas_workcell where id<>#{id} and del_flag=0")
    List<WorkCell> otherWorkCell(String id);

    @Insert("insert into bas_workcell(id,cellName,cellNumber,cellMaster,cellDescription,station_id,del_flag,remarks," +
            "create_by,create_date,update_by,update_date) " +
            "values(#{id},#{cellName},#{cellNumber},#{cellMaster},#{cellDescription},#{station_id},#{del_flag}," +
            "#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertWorkCell(WorkCell workCell);

    @Update("update bas_workcell set cellName=#{cellName},cellNumber=#{cellNumber},cellMaster=#{cellMaster}," +
            "cellDescription=#{cellDescription},station_id=#{station_id},del_flag=#{del_flag},remarks=#{remarks}," +
            "update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateWorkCell(WorkCell workCell);

    @Update("update bas_workcell set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteWorkCell(WorkCell workCell);
}
