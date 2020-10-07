package com.example.skill_training.mapper;

import com.example.skill_training.entity.FlowProcess;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowProcessMapper {
    @Select("select * from tec_flow_process where flow_id=#{flow_id} and del_flag=0")
    List<FlowProcess> allFlowProcess(String flow_id);
}
