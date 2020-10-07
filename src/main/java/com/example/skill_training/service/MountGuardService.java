package com.example.skill_training.service;

import com.example.skill_training.entity.MountGuard;

import java.util.List;

public interface MountGuardService {
    List<MountGuard> all_MountGuard();
    List<MountGuard> selectBy_EmployeeNo(String employeeNo);
    List<MountGuard> selectBy_CellName(String cellName);
    List<MountGuard> selectBy_WorkStatus(String workStatus);
    List<MountGuard> selectNotBy_WorkStatus(String employeeNo,String cellName);
    List<MountGuard> selectNotBy_CellName(String employeeNo,String workStatus);
    List<MountGuard> selectNotBy_EmployeeNo(String cellName,String workStatus);
    List<MountGuard> selectOne_Employee(String employeeNo,String cellName,String workStatus);
}
