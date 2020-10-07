package com.example.skill_training.service.impl;

import com.example.skill_training.entity.FlowProcess;
import com.example.skill_training.mapper.FlowProcessMapper;
import com.example.skill_training.service.FlowProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowProcessServiceImpl implements FlowProcessService {
    @Autowired
    FlowProcessMapper flowProcessMapper;
    @Override
    public List<FlowProcess> all_FlowProcess(String flow_id) {
        return flowProcessMapper.allFlowProcess(flow_id);
    }

}
