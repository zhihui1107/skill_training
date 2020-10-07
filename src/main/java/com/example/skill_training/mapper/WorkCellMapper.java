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
    @Select("select bas_workcell.*,bas_workstationinfos.* from bas_workcell left join bas_workstationinfos on bas_workcell.station_id=bas_workstationinfos.id")
    List<WorkCell> allWorkCell();

    @Select("select * from bas_workcell where cellName=#{cellName}")
    WorkCell oneWorkCell(String cellName);

    @Select("select * from bas_workcell where id=#{id}")
    WorkCell selectById(String id);

    @Select("select * from bas_workcell where id<>#{id}")
    List<WorkCell> otherWorkCell(String id);

    @Insert("insert into bas_workcell(id,cellName,cellNumber,cellMaster,cellDescription,station_id,create_date) " +
            "values(#{id},#{cellName},#{cellNumber},#{cellMaster},#{cellDescription},#{station_id},#{create_date})")
    boolean insertWorkCell(WorkCell workCell);

    @Update("update bas_workcell set cellName=#{cellName},cellNumber=#{cellNumber},cellMaster=#{cellMaster}," +
            "cellDescription=#{cellDescription},station_id=#{station_id},update_date=#{update_date} where id=#{id}")
    boolean updateWorkCell(WorkCell workCell);

    @Delete("delete from bas_workcell where cellName=#{cellName}")
    boolean deleteWorkCell(String cellName);
}
