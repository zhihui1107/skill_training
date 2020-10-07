package com.example.skill_training.mapper;

import com.example.skill_training.entity.Electronsteelyard;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ElectronsteelyardMapper {
    /* 1.根据条件查询PAD信息 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardBysit(String spec,String id,String type);

    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.qrCode=#{qrCode} and a.del_flag=0 ;")
    Electronsteelyard search_ElectronsteelyardByq(String qrCode);

    /*1.1*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardBys(String spec);
    /*1.2*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardByi(String id);
    /*1.3*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.type=#{type} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardByt(String type);
    /*1.4*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardBysi(String spec,String id);
    /*1.5*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.type=#{type} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardByst(String spec,String type);
    /*1.6*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Electronsteelyard> search_ElectronsteelyardByit(String id,String type);

    /* 2.查询所有 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_electronsteelyard a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.del_flag=0 ")
    List<Electronsteelyard> allElectronsteelyard();
    /* 3.添加 */
    @Insert("insert into bas_electronsteelyard(id,qrCode,type,spec,station_id,cell_id,eSName,eSRange,eSWeight,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,del_flag,create_by,create_date,update_by,update_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{eSName},#{eSRange},#{eSWeight},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{del_flag},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertElectronsteelyard(Electronsteelyard electronsteelyard);
    /* 4.修改 */
    @Update("update bas_electronsteelyard set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},eSName=#{eSName},eSRange=#{eSRange},eSWeight=#{eSWeight},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updateElectronsteelyard(Electronsteelyard electronsteelyard);
    /* 5.删除 */
    @Update("update bas_electronsteelyard set del_flag=1 where id=#{id};")
    boolean deleteElectronsteelyard(String id);
}
