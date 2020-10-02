package com.example.skill_training.mapper;

import com.example.skill_training.entity.Company;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyMapper {
    @Select("select * from bas_enterprise")
    List<Company> allCompany();

    @Select("select * from bas_enterprise where enterName=#{enterName}")
    Company oneCompany(String enterName);

    @Select("select * from bas_enterprise where id=#{id}")
    Company selectById(String id);

    @Select("select * from bas_enterprise where id<>#{id}")
    List<Company> otherCompany(String id);

    @Insert("insert into bas_enterprise(id,enterName,enterCode,enterLevel,enterNature,enterCapital,enterLperson," +
            "enterLpCard,enterAddress,emailCode,enterRemarks,create_date) " +
            "values(#{id},#{enterName},#{enterCode},#{enterLevel},#{enterNature},#{enterCapital},#{enterLperson}," +
            "#{enterLpCard},#{enterAddress},#{emailCode},#{enterRemarks},#{create_date})")
    boolean insertCompany(Company company);

    @Update("update bas_enterprise set enterName=#{enterName},enterCode=#{enterCode},enterLevel=#{enterLevel}," +
            "enterNature=#{enterNature},enterCapital=#{enterCapital},enterLperson=#{enterLperson},enterLpCard=#{enterLpCard}," +
            "enterAddress=#{enterAddress},emailCode=#{emailCode},enterRemarks=#{enterRemarks},update_date=#{update_date} where id=#{id}")
    boolean updateCompany(Company company);

    @Delete("delete from bas_enterprise where enterName=#{enterName}")
    boolean deleteCompany(String enterName);
}
