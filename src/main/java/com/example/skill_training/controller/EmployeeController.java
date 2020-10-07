package com.example.skill_training.controller;

import com.example.skill_training.entity.Employee;
import com.example.skill_training.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/employee")
    public String getAllEmployee(Model model){
        List<Employee> employeeList=employeeService.all_Employee();
        model.addAttribute("employeeList",employeeList);
        return "employee_list";
    }
    @RequestMapping(value = "/oneEmployee",method = RequestMethod.POST)
    public String getOneEmployee(String select_no,String select_name,Model model){
        if(select_no.equals("")&&select_name.equals("")){
            return "redirect:/employee";
        }else if(select_no.equals("")){
            List<Employee> employeeList=employeeService.one_EmployeeName(select_name);
            model.addAttribute("employeeList",employeeList);
        }else if(select_name.equals("")){
            Employee employee=employeeService.one_EmployeeNo(select_no);
            model.addAttribute("employee",employee);
        }else {
            Employee employee=employeeService.one_Employee(select_no,select_name);
            model.addAttribute("employee",employee);
        }
        return "employee_list";
    }
    @RequestMapping(value = "/insert_employee",method = RequestMethod.POST)
    public String addEmployee(String id,String employeeNo,String employeeName,String workDate,String sex,String age,
                             String teNum,String address,String email,String idCard,String officeId){
        Employee employee=new Employee();
        employee.setEmployeeNo(employeeNo);
        employee.setEmployeeName(employeeName);
        employee.setWorkDate(workDate);
        employee.setSex(sex);
        employee.setAge(age);
        employee.setTeNum(teNum);
        employee.setAddress(address);
        employee.setEmail(email);
        employee.setIdCard(idCard);
        employee.setOfficeId(officeId);
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(!id.equals("")){
            employee.setId(id);
            employee.setUpdate_date(dateFormat.format(date));
            employeeService.update_Employee(employee);
        }else {
            employee.setId(UUID.randomUUID().toString().replaceAll("-",""));
            employee.setCreate_date(dateFormat.format(date));
            employeeService.insert_Employee(employee);
        }
        return "redirect:/employee";
    }
    @GetMapping("/delete_employee/{employeeNo}")
    public String deleteOneCompany(@PathVariable("employeeNo") String employeeNo){
        employeeService.delete_Employee(employeeNo);
        return "redirect:/employee";
    }
    @GetMapping("/update_employee/{id}")
    public String updateOneEmployee(@PathVariable("id") String id,Model model){
        Employee employee=employeeService.select_ById(id);
        model.addAttribute("employee",employee);
        model.addAttribute("employee_id",id);
        return "employee_form";
    }
    @RequestMapping("/form_employee")
    public String formEmployee(){
        return "employee_form";
    }
}
