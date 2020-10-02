package com.example.skill_training.mapper;

import com.example.skill_training.entity.MountGuard;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MountGuardMapper {
    @Select("select * from mount_guard")
    List<MountGuard> allMountGuard();

    @Select("select * from mount_guard where employeeNo=#{employeeNo}")
    List<MountGuard> selectByEmployeeNo(String employeeNo);

    @Select("select * from mount_guard where cellName=#{cellName}")
    List<MountGuard> selectByCellName(String cellName);

    @Select("select * from mount_guard where workStatus=#{workStatus}")
    List<MountGuard> selectByWorkStatus(String workStatus);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and cellName=#{cellName}")
    List<MountGuard> selectNotByWorkStatus(String employeeNo,String cellName);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and workStatus=#{workStatus}")
    List<MountGuard> selectNotByCellName(String employeeNo,String workStatus);

    @Select("select * from mount_guard where cellName=#{cellName} and workStatus=#{workStatus}")
    List<MountGuard> selectNotByEmployeeNo(String cellName,String workStatus);

    @Select("select * from mount_guard where employeeNo=#{employeeNo} and cellName=#{cellName} and workStatus=#{workStatus}")
    List<MountGuard> selectOneEmployee(String employeeNo,String cellName,String workStatus);
}
