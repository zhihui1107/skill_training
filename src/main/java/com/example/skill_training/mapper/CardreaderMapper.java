package com.example.skill_training.mapper;

import com.example.skill_training.entity.Cardreader;
import com.example.skill_training.entity.androidPAD;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardreaderMapper {
    /* 1.根据条件查询读卡器信息 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderBysit(String spec,String id,String type);

    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.qrCode=#{qrCode} and a.del_flag=0 ;")
    Cardreader search_CardreaderByq(String qrCode);

    /*1.1*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderBys(String spec);
    /*1.2*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderByi(String id);
    /*1.3*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.type=#{type} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderByt(String type);
    /*1.4*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.id=#{id} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderBysi(String spec,String id);
    /*1.5*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.spec=#{spec} and a.type=#{type} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderByst(String spec,String type);
    /*1.6*/
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a \n" +
            "left join bas_workcell b on a.cell_id=b.id\n" +
            "left join bas_workstationinfos c on a.station_id=c.id\n" +
            "where a.id=#{id} and a.type=#{type} and a.del_flag=0 ;")
    List<Cardreader> search_CardreaderByit(String id,String type);


    /* 2.查询所有 */
    @Select("select a.*,b.cellName,c.stationName\n" +
            "from bas_cardreader a\n" +
            "left join bas_workcell b on b.id=a.cell_id\n" +
            "left join bas_workstationinfos c on c.id=a.station_id\n" +
            "where a.del_flag=0 ;")
    List<Cardreader> allCardreader();
    /* 3.添加 */
    @Insert("insert into bas_cardreader(id,qrCode,type,spec,station_id,cell_id,readerSpeed,timeInterval,distance,readerType,frequency,supplier,manufacturer,factoryNumber,purpose,buyDate,person,organization,remarks,del_flag,create_by,create_date,update_by,update_date) values(#{id},#{qrCode},#{type},#{spec},#{station_id},#{cell_id},#{readerSpeed},#{timeInterval},#{distance},#{readerType},#{frequency},#{supplier},#{manufacturer},#{factoryNumber},#{purpose},#{buyDate},#{person},#{organization},#{remarks},#{del_flag},#{create_by},#{create_date},#{update_by},#{update_date})")
    boolean insertCardreader(Cardreader Cardreader);
    /* 4.修改 */
    @Update("update bas_cardreader set id=#{id},type=#{type},spec=#{spec},station_id=#{station_id},cell_id=#{cell_id},readerSpeed=#{readerSpeed},timeInterval=#{timeInterval},distance=#{distance},readerType=#{readerType},frequency=#{frequency},supplier=#{supplier},manufacturer=#{manufacturer},factoryNumber=#{factoryNumber},purpose=#{purpose},buyDate=#{buyDate},person=#{person},organization=#{organization},remarks=#{remarks},update_by=#{update_by},update_date=#{update_date} where qrCode=#{qrCode}")
    boolean updateCardreader(Cardreader cardreader);
    /* 5.删除 */
    @Update("update bas_cardreader set del_flag=1 where id=#{id};")
    boolean deleteCardreader(String id);
}
