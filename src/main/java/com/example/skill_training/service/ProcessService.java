package com.example.skill_training.service;

import com.example.skill_training.entity.Process;

import java.util.List;

public interface ProcessService {
    Process select_ById(String id);
    List<Process> select_ProcessById(String id);
}
