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
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<androidPAD> search_PADBysit(String spec,String id,String type);

    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.qrCode=#{qrCode} and a.del_flag=0 ;")
    androidPAD search_PADByq(String qrCode);

    /*1.1*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.del_flag=0 ;")
    List<androidPAD> search_PADBys(String spec);
    /*1.2*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.del_flag=0 ;")
    List<androidPAD> search_PADByi(String id);
    /*1.3*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.type=#{type} and a.del_flag=0 ;")
    List<androidPAD> search_PADByt(String type);
    /*1.4*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.del_flag=0 ;")
    List<androidPAD> search_PADBysi(String spec,String id);
    /*1.5*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.type=#{type} and a.del_flag=0 ;")
    List<androidPAD> search_PADByst(String spec,String type);
    /*1.6*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<androidPAD> search_PADByit(String id,String type);

    /* 2.查询所有 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_pad a\n" +
            "left join bas_workcell b on b.id=a.cell_id\n" +
            "left join bas_workstationinfos c on c.id=a.station_id\n" +
            "where a.del_flag=0 ;")
    List<androidPAD> allPAD();
    /* 3.添加 */
    @Insert("insert into bas_pad(id,qrCode,type,spec,station_id,cell_id,pADsc,pADNucleus,pADMemory,capacity,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,del_flag,create_by,create_date,update_by,update_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{pADsc},#{pADNucleus},#{pADMemory},#{capacity},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{del_flag},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertPAD(androidPAD androidPAD);
    /* 4.修改 */
    @Update("update bas_pad set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},pADsc=#{pADsc},pADNucleus=#{pADNucleus},pADMemory=#{pADMemory},capacity=#{capacity},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_by=#{updateBy},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updatePAD(androidPAD androidPAD);
    /* 5.删除 */
    @Update("update bas_pad set del_flag=1 where id=#{id};")
    boolean deletePAD(String id);
}
