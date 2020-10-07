package com.example.skill_training.service;

import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;

import java.util.List;

public interface EquipCommonService {
    List<WorkCell> getAllCellName();
    List<WorkStation> getAllStationName();
}
