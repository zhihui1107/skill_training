package com.example.skill_training.mapper;

import com.example.skill_training.entity.Codeprinter;
import com.example.skill_training.entity.androidPAD;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CodeprinterMapper {
    /* 1.根据条件查询电子打印机信息 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterBysit(String spec,String id,String type);

    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.qrCode=#{qrCode} and a.del_flag=0 ;")
    Codeprinter search_CodeprinterByq(String qrCode);

    /*1.1*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterBys(String spec);
    /*1.2*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterByi(String id);
    /*1.3*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.type=#{type} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterByt(String type);
    /*1.4*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterBysi(String spec,String id);
    /*1.5*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.type=#{type} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterByst(String spec,String type);
    /*1.6*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Codeprinter> search_CodeprinterByit(String id,String type);

    /* 2.查询所有 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_codeprinter a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.del_flag=0 ")
    List<Codeprinter> allCodeprinter();
    /* 3.添加 */
    @Insert("insert into bas_codeprinter(id,qrCode,type,spec,station_id,cell_id,resolution,cPNumber,mode,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,del_flag.create_by,create_date,update_by,update_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{resolution},#{cPNumber},#{mode},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{del_flag},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertCodeprinter(Codeprinter codeprinter);
    /* 4.修改 */
    @Update("update bas_codeprinter set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},resolution=#{resolution},cPNumber=#{cPNumber},mode=#{mode},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updateCodeprinter(Codeprinter codeprinter);
    /* 5.删除 */
    @Update("update bas_codeprinter set del_flag=1 where id=#{id};")
    boolean deleteCodeprinter(String id);
}
