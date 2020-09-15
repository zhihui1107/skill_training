package com.example.skill_training.mapper;

import com.example.skill_training.entity.androidPAD;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface androidPADMapper {
    /* 1.根据条件查询PAD信息 */
    @Select("select * from bas_pad where spec=#{spec} and id=#{id} and type=#{type};")
    androidPAD search_PAD(String spec,String id,String type);

    /* 2.查询所有 */
    @Select("select * from bas_pad;")
    List<androidPAD> allPAD();
    /* 3.添加 */
    @Insert("insert into bas_pad(id,qrCode,type,spec,station_id,cell_id,pADsc,pADNucleus,pADMemory,capacity,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,create_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{pADsc},#{pADNucleus},#{pADMemory},#{capacity},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{create_date})")
    boolean insertPAD(androidPAD androidPAD);
    /* 4.修改 */
    @Update("update bas_pad set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},pADsc=#{pADsc},pADNucleus=#{pADNucleus},pADMemory=#{pADMemory},capacity=#{capacity},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updatePAD(String qrCode);
    /* 5.删除 */
    @Delete("delete from bas_pad where id=#{id};")
    boolean deletePAD(String id);
}
