package com.example.skill_training.mapper;

import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.entity.WorkCell;


import java.util.List;
@Repository
public interface EquipCommonMapper {
    @Select("select id,stationName from bas_workstationinfos;")
    List<WorkStation> StationName();

    @Select("select id,CellName from bas_workcell;")
    List<WorkCell> CellName();
}
