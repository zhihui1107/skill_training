package com.example.skill_training.mapper;

import com.example.skill_training.entity.Iphoto;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IphotoMapper {
    /* 1.根据条件查询红外对射枪信息 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.type=#{type} and del_flag=0 ;")
    List<Iphoto> search_IphotoBysit(String spec,String id,String type);

    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.qrCode=#{qrCode} and del_flag=0 ;")
    Iphoto search_IphotoByq(String qrCode);

    /*1.1*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and del_flag=0 ;")
    List<Iphoto> search_IphotoBys(String spec);
    /*1.2*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and del_flag=0 ;")
    List<Iphoto> search_IphotoByi(String id);
    /*1.3*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.type=#{type} and del_flag=0 ;")
    List<Iphoto> search_IphotoByt(String type);
    /*1.4*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and del_flag=0 ;")
    List<Iphoto> search_IphotoBysi(String spec,String id);
    /*1.5*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.type=#{type} and del_flag=0 ;")
    List<Iphoto> search_IphotoByst(String spec,String type);
    /*1.6*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.type=#{type} and del_flag=0 ;")
    List<Iphoto> search_IphotoByit(String id,String type);

    /* 2.查询所有 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_iphoto a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.del_flag=0 ")
    List<Iphoto> allIphoto();
    /* 3.添加 */
    @Insert("insert into bas_iphoto(id,qrCode,type,spec,station_id,cell_id,iphotoDistance,iphotoWay,workEnvironment,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,del_flag,create_by,create_date,update_by,update_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{iphotoDistance},#{iphotoWay},#{workEnvironment},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{del_flag},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertIphoto(Iphoto iphoto);
    /* 4.修改 */
    @Update("update bas_iphoto set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},iphotoDistance=#{iphotoDistance},iphotoWay=#{iphotoWay},workEnvironment=#{workEnvironment},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updateIphoto(Iphoto iphoto);
    /* 5.删除 */
    @Update("update bas_iphoto set del_flag=1 where id=#{id};")
    boolean deleteIphoto(String id);
}
