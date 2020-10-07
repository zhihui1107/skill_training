package com.example.skill_training.service.impl;

import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.mapper.WorkCellMapper;
import com.example.skill_training.service.WorkCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkCellServiceImpl implements WorkCellService {
    @Autowired
    WorkCellMapper workCellMapper;
    @Override
    public List<WorkCell> all_WorkCell() {
        return workCellMapper.allWorkCell();
    }

    @Override
    public WorkCell one_WorkCell(String cellName) {
        return workCellMapper.oneWorkCell(cellName);
    }

    @Override
    public WorkCell select_ById(String id) {
        return workCellMapper.selectById(id);
    }

    @Override
    public List<WorkCell> other_Cell(String id) {
        return workCellMapper.otherWorkCell(id);
    }

    @Override
    public boolean insert_WorkCell(WorkCell workShop) {
        return workCellMapper.insertWorkCell(workShop);
    }

    @Override
    public boolean delete_WorkCell(WorkCell workShop) {
        return workCellMapper.deleteWorkCell(workShop);
    }

    @Override
    public boolean update_WorkCell(WorkCell workShop) {
        return workCellMapper.updateWorkCell(workShop);
    }
}
