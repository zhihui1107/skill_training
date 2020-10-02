package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Employee;
import com.example.skill_training.mapper.EmployeeMapper;
import com.example.skill_training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public List<Employee> all_Employee() {
        return employeeMapper.allEmployee();
    }

    @Override
    public List<Employee> other_Employee() {
        return employeeMapper.otherEmployee();
    }

    @Override
    public Employee one_EmployeeNo(String employeeNo) {
        return employeeMapper.oneEmployeeNo(employeeNo);
    }

    @Override
    public List<Employee> one_EmployeeName(String employeeName) {
        return employeeMapper.oneEmployeeName(employeeName);
    }

    @Override
    public Employee one_Employee(String employeeNo, String employeeName) {
        return employeeMapper.oneEmployee(employeeNo,employeeName);
    }

    @Override
    public Employee select_ById(String id) {
        return employeeMapper.selectById(id);
    }

    @Override
    public boolean insert_Employee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public boolean delete_Employee(String employeeNo) {
        return employeeMapper.deleteEmployee(employeeNo);
    }

    @Override
    public boolean update_Employee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
}
