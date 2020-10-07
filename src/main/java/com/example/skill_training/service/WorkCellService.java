package com.example.skill_training.service;

import com.example.skill_training.entity.WorkCell;

import java.util.List;

public interface WorkCellService {
    List<WorkCell> all_WorkCell();
    WorkCell one_WorkCell(String cellName);
    WorkCell select_ById(String id);
    List<WorkCell> other_Cell(String id);
    boolean insert_WorkCell(WorkCell workShop);
    boolean delete_WorkCell(String cellName);
    boolean update_WorkCell(WorkCell workShop);
}
