package com.example.skill_training.service;

import com.example.skill_training.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> all_Employee();
    List<Employee> other_Employee();
    Employee one_EmployeeNo(String employeeNo);
    List<Employee> one_EmployeeName(String employeeName);
    Employee one_Employee(String employeeNo,String employeeName);
    Employee select_ById(String id);
    boolean insert_Employee(Employee employee);
    boolean delete_Employee(String employeeNo);
    boolean update_Employee(Employee employee);
}
