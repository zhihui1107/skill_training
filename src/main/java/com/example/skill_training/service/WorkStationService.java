package com.example.skill_training.service;

import com.example.skill_training.entity.WorkStation;

import java.util.List;

public interface WorkStationService {
    List<WorkStation> all_WorkStation();
    WorkStation one_WorkStation(String stationName);
    WorkStation select_ById(String id);
    List<WorkStation> other_WorkStation(String id);
    boolean insert_WorkStation(WorkStation workStation);
    boolean delete_WorkStation(WorkStation workStation);
    boolean update_WorkStation(WorkStation workStation);
}
