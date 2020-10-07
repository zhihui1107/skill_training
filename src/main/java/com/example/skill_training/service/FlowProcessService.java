package com.example.skill_training.service;

import com.example.skill_training.entity.FlowProcess;

import java.util.List;

public interface FlowProcessService {
    List<FlowProcess> all_FlowProcess(String flow_id);
}
