package com.example.skill_training.service.impl;

import com.example.skill_training.entity.CellEmployee;
import com.example.skill_training.mapper.CellEmployeeMapper;
import com.example.skill_training.service.CellEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellEmployeeServiceImpl implements CellEmployeeService {
    @Autowired
    CellEmployeeMapper cellEmployeeMapper;
    @Override
    public List<CellEmployee> all_CellEmployee() {
        return cellEmployeeMapper.allCellEmployee();
    }

    @Override
    public CellEmployee one_CellEmployee_employeeName(String employeeName) {
        return cellEmployeeMapper.oneCellEmployee_employeeName(employeeName);
    }

    @Override
    public List<CellEmployee> one_CellEmployee_cellName(String cellName) {
        return cellEmployeeMapper.oneCellEmployee_cellName(cellName);
    }

    @Override
    public CellEmployee one_CellEmployee(String employeeName, String cellName) {
        return cellEmployeeMapper.oneCellEmployee(employeeName, cellName);
    }

    @Override
    public CellEmployee select_ById(String id) {
        return cellEmployeeMapper.selectById(id);
    }

    @Override
    public boolean insert_CellEmployee(CellEmployee cellEmployee) {
        return cellEmployeeMapper.insertCellEmployee(cellEmployee);
    }

    @Override
    public boolean delete_CellEmployee(String employee_id) {
        return cellEmployeeMapper.deleteCellEmployee(employee_id);
    }

    @Override
    public boolean update_CellEmployee(CellEmployee cellEmployee) {
        return cellEmployeeMapper.updateCellEmployee(cellEmployee);
    }
}
