package com.example.skill_training.service.impl;

import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.mapper.EquipCommonMapper;
import com.example.skill_training.service.EquipCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipCommonServiceImpl implements EquipCommonService {
@Autowired

    EquipCommonMapper equipCommonMapper;
    @Override
    public List<WorkCell> getAllCellName() {
        return equipCommonMapper.CellName();
    }

    @Override
    public List<WorkStation> getAllStationName() {
        return equipCommonMapper.StationName();
    }
}
