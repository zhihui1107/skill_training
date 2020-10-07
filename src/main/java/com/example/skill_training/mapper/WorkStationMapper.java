package com.example.skill_training.mapper;

import com.example.skill_training.entity.WorkStation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WorkStationMapper {
    @Select("select bas_workstationinfos.*,bas_line.* from bas_workstationinfos left join bas_line on bas_workstationinfos.line_id=bas_line.id")
    List<WorkStation> allWorkStation();

    @Select("select * from bas_workstationinfos where stationName=#{stationName}")
    WorkStation oneWorkStation(String stationName);

    @Select("select * from bas_workstationinfos where id=#{id}")
    WorkStation selectById(String id);

    @Select("select * from bas_workstationinfos where id<>#{id}")
    List<WorkStation> otherWorkStation(String id);

    @Insert("insert into bas_workstationinfos(id,stationName,stationNo,stationMaster,line_id,create_date) " +
            "values(#{id},#{stationName},#{stationNo},#{stationMaster},#{line_id},#{create_date})")
    boolean insertWorkStation(WorkStation workStation);

    @Update("update bas_workstationinfos set stationName=#{stationName},stationNo=#{stationNo},stationMaster=#{stationMaster}," +
            "line_id=#{line_id},update_date=#{update_date} where id=#{id}")
    boolean updateWorkStation(WorkStation workStation);

    @Delete("delete from bas_workstationinfos where stationName=#{stationName}")
    boolean deleteWorkStation(String stationName);
}
