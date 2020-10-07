package com.example.skill_training.service.impl;

import com.example.skill_training.entity.MountGuard;
import com.example.skill_training.mapper.MountGuardMapper;
import com.example.skill_training.service.MountGuardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MountGuardServiceImpl implements MountGuardService {
    @Autowired
    MountGuardMapper mountGuardMapper;
    @Override
    public List<MountGuard> all_MountGuard() {
        return mountGuardMapper.allMountGuard();
    }

    @Override
    public List<MountGuard> selectBy_EmployeeNo(String employeeNo) {
        return mountGuardMapper.selectByEmployeeNo(employeeNo);
    }

    @Override
    public List<MountGuard> selectBy_CellName(String cellName) {
        return mountGuardMapper.selectByCellName(cellName);
    }

    @Override
    public List<MountGuard> selectBy_WorkStatus(String workStatus) {
        return mountGuardMapper.selectByWorkStatus(workStatus);
    }

    @Override
    public List<MountGuard> selectNotBy_WorkStatus(String employeeNo, String cellName) {
        return mountGuardMapper.selectNotByWorkStatus(employeeNo, cellName);
    }

    @Override
    public List<MountGuard> selectNotBy_CellName(String employeeNo, String workStatus) {
        return mountGuardMapper.selectNotByCellName(employeeNo, workStatus);
    }

    @Override
    public List<MountGuard> selectNotBy_EmployeeNo(String cellName, String workStatus) {
        return mountGuardMapper.selectNotByEmployeeNo(cellName, workStatus);
    }

    @Override
    public List<MountGuard> selectOne_Employee(String employeeNo, String cellName, String workStatus) {
        return mountGuardMapper.selectOneEmployee(employeeNo, cellName, workStatus);
    }
}
