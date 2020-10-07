package com.example.skill_training.mapper;

import com.example.skill_training.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    @Select("select * from orders left join sys_dict on orders.unit=sys_dict.value " +
            "where orders.del_flag=0 and sys_dict.del_flag=0")
    List<Order> allOrder();

    @Select("select * from orders where id=#{id} and del_flag=0")
    Order selectById(String id);

    @Select("select * from orders where orderNo=#{orderNo}")
    Order selectByOrderNo(String orderNo);

    @Insert("insert into orders(id,orderNo,indentor,product_id,quantity,unit,orderDate,salesman,status,del_flag,remarks," +
            "create_by,create_date,update_by,update_date) " +
            "values (#{id},#{orderNo},#{indentor},#{product_id},#{quantity},#{unit},#{orderDate}," +
            "#{salesman},#{status},#{del_flag},#{remarks},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertOrder(Order order);

    @Update("update orders set status=#{status}")
    boolean updateStatus(Order order);
}
