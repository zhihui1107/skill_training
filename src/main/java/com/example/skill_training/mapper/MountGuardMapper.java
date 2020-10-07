package com.example.skill_training.mapper;

import com.example.skill_training.entity.MountGuard;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MountGuardMapper {
    @Select("select * from mount_guard where del_flag=0")
    List<MountGuard> allMountGuard();

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and del_flag=0")
    List<MountGuard> selectByEmployeeNo(String employeeNo);

    @Select("select * from mount_guard where cellName=#{cellName} and del_flag=0")
    List<MountGuard> selectByCellName(String cellName);

    @Select("select * from mount_guard where workStatus=#{workStatus} and del_flag=0")
    List<MountGuard> selectByWorkStatus(String workStatus);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and cellName=#{cellName} and del_flag=0")
    List<MountGuard> selectNotByWorkStatus(String employeeNo,String cellName);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and workStatus=#{workStatus} and del_flag=0")
    List<MountGuard> selectNotByCellName(String employeeNo,String workStatus);

    @Select("select * from mount_guard where cellName=#{cellName} and workStatus=#{workStatus} and del_flag=0")
    List<MountGuard> selectNotByEmployeeNo(String cellName,String workStatus);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and cellName=#{cellName} and workStatus=#{workStatus} and del_flag=0")
    List<MountGuard> selectOneEmployee(String employeeNo,String cellName,String workStatus);
}
