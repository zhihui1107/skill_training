package com.example.skill_training.mapper;

import com.example.skill_training.entity.WorkOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderMapper {
    @Select("select * from bas_workorder where del_flag=0")
    List<WorkOrder> allWorkOrder();

    @Select("select * from bas_workorder where orderCode=#{orderCode} and del_flag=0")
    List<WorkOrder> selectByOrderCode(String orderCode);

    @Select("select * from bas_workorder where id=#{id} and del_flag=0")
    WorkOrder selectById(String id);

    @Insert("insert into bas_workorder(id,order_id,orderCode,unitName,orderType,amount,estStartTime,estEndTime," +
            "actStartTime,inAmount,outAmount,scrapAmount,state,line_id,product_id,del_flag,remarks,create_by," +
            "create_date,update_by,update_date) values(#{id},#{order_id},#{orderCode},#{unitName},#{orderType}," +
            "#{amount},#{estStartTime},#{estEndTime},#{actStartTime},#{inAmount},#{outAmount},#{scrapAmount}," +
            "#{state},#{line_id},#{product_id},#{del_flag},#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertOneWorkOrder(WorkOrder workOrder);

    @Update("update bas_workorder set order_id=#{order_id},orderCode=#{orderCode},unitName=#{unitName}," +
            "orderType=#{orderType},amount=#{amount},estStartTime=#{estStartTime},estEndTime=#{estEndTime}," +
            "actStartTime=#{actStartTime},inAmount=#{inAmount},outAmount=#{outAmount},scrapAmount=#{scrapAmount}," +
            "state=#{state},line_id=#{line_id},product_id=#{product_id},del_flag=#{del_flag},remarks=#{remarks}," +
            "update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean updateWorkOrder(WorkOrder workOrder);

    @Update("update bas_workorder set del_flag=#{del_flag},update_by=#{update_by},update_date=#{update_date} where id=#{id}")
    boolean deleteWorkOrder(WorkOrder workOrder);
}
