package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Flow;
import com.example.skill_training.mapper.FlowMapper;
import com.example.skill_training.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    FlowMapper flowMapper;
    @Override
    public Flow select_ById(String id) {
        return flowMapper.selectById(id);
    }
}
