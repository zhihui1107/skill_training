package com.example.skill_training.service.impl;

import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.mapper.WorkStationMapper;
import com.example.skill_training.service.WorkStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkStationServiceImpl implements WorkStationService {
    @Autowired
    WorkStationMapper workStationMapper;
    @Override
    public List<WorkStation> all_WorkStation() {
        return workStationMapper.allWorkStation();
    }

    @Override
    public WorkStation one_WorkStation(String stationName) {
        return workStationMapper.oneWorkStation(stationName);
    }

    @Override
    public WorkStation select_ById(String id) {
        return workStationMapper.selectById(id);
    }

    @Override
    public List<WorkStation> other_WorkStation(String id) {
        return workStationMapper.otherWorkStation(id);
    }

    @Override
    public boolean insert_WorkStation(WorkStation workStation) {
        return workStationMapper.insertWorkStation(workStation);
    }

    @Override
    public boolean delete_WorkStation(String stationName) {
        return workStationMapper.deleteWorkStation(stationName);
    }

    @Override
    public boolean update_WorkStation(WorkStation workStation) {
        return workStationMapper.updateWorkStation(workStation);
    }
}
