package com.example.skill_training.mapper;

import com.example.skill_training.entity.Process;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessMapper {
    @Select("select * from tec_process where id=#{id} and del_flag=0")
    Process selectById(String id);

    @Select("select * from tec_flow_process left join tec_flow on tec_flow_process.flow_id=tec_flow.id " +
            "left join tec_process on tec_flow_process.pro_id=tec_process.id left join bas_product on " +
            "tec_flow_process.flow_id=bas_product.flow_id where bas_product.id=#{id} " +
            "and tec_flow_process.del_flag=0 and tec_flow.del_flag=0 and tec_process.del_flag=0 and bas_product.del_flag=0")
    List<Process> selectProcessById(String id);
}
