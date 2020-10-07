package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Process;
import com.example.skill_training.mapper.ProcessMapper;
import com.example.skill_training.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    ProcessMapper processMapper;
    @Override
    public Process select_ById(String id) {
        return processMapper.selectById(id);
    }

    @Override
    public List<Process> select_ProcessById(String id) {
        return processMapper.selectProcessById(id);
    }
}
