package com.example.skill_training.service;

import com.example.skill_training.entity.CellEmployee;

import java.util.List;

public interface CellEmployeeService {
    List<CellEmployee> all_CellEmployee();
    CellEmployee one_CellEmployee_employeeName(String employeeName);
    List<CellEmployee> one_CellEmployee_cellName(String cellName);
    CellEmployee one_CellEmployee(String employeeName,String cellName);
    CellEmployee select_ById(String id);
    boolean insert_CellEmployee(CellEmployee cellEmployee);
    boolean delete_CellEmployee(String employee_id);
    boolean update_CellEmployee(CellEmployee cellEmployee);
}
