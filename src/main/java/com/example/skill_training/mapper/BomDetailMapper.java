package com.example.skill_training.mapper;

import com.example.skill_training.entity.BomDetail;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BomDetailMapper {
    @Select("select * from bas_bom_detail where bom_id=#{bom_id} and del_flag=0")
    List<BomDetail> allBomDetail(String bom_id);
}
