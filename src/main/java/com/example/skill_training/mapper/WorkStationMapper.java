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
    @Select("select * from bas_workstationinfos left join bas_line on bas_workstationinfos.line_id=bas_line.id " +
            "where bas_workstationinfos.del_flag=0 and bas_line.del_flag=0")
    List<WorkStation> allWorkStation();

    @Select("select * from bas_workstationinfos where stationName=#{stationName} and del_flag=0")
    WorkStation oneWorkStation(String stationName);

    @Select("select * from bas_workstationinfos where id=#{id} and del_flag=0")
    WorkStation selectById(String id);

    @Select("select * from bas_workstationinfos where id<>#{id} and del_flag=0")
    List<WorkStation> otherWorkStation(String id);

    @Insert("insert into bas_workstationinfos(id,stationName,stationNo,stationMaster,line_id,del_flag,remarks," +
            "create_by,create_date,update_by,update_date) " +
            "values(#{id},#{stationName},#{stationNo},#{stationMaster},#{line_id},#{del_flag},#{remarks}," +
            "#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertWorkStation(WorkStation workStation);

    @Update("update bas_workstationinfos set stationName=#{stationName},stationNo=#{stationNo},stationMaster=#{stationMaster}," +
            "line_id=#{line_id},del_flag=#{del_flag},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateWorkStation(WorkStation workStation);

    @Update("update bas_workstationinfos set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteWorkStation(WorkStation workStation);
}
