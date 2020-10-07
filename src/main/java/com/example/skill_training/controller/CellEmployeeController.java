package com.example.skill_training.controller;

import com.example.skill_training.entity.CellEmployee;
import com.example.skill_training.entity.Company;
import com.example.skill_training.entity.Employee;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.service.CellEmployeeService;
import com.example.skill_training.service.EmployeeService;
import com.example.skill_training.service.WorkCellService;
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
public class CellEmployeeController {
    @Autowired
    CellEmployeeService cellEmployeeService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    WorkCellService workCellService;
    @RequestMapping("/cellemployee")
    public String getAllCellEmployee(Model model){
        List<CellEmployee> cellEmployeeList=cellEmployeeService.all_CellEmployee();
        model.addAttribute("cellEmployeeList",cellEmployeeList);
        return "cellemployee_list";
    }
    @RequestMapping(value = "/oneCellEmployee",method = RequestMethod.POST)
    public String getOneCellEmployee(String select_employee,String select_workcell,Model model){
        if(select_employee.equals("")&&select_workcell.equals("")){
            return "redirect:/cellemployee";
        }else if(select_employee.equals("")){
            List<CellEmployee> cellEmployeeList=cellEmployeeService.one_CellEmployee_cellName(select_workcell);
            model.addAttribute("cellEmployeeList",cellEmployeeList);
        }else if(select_workcell.equals("")){
            CellEmployee cellEmployee=cellEmployeeService.one_CellEmployee_employeeName(select_employee);
            model.addAttribute("cellEmployee",cellEmployee);
        } else {
            CellEmployee cellEmployee=cellEmployeeService.one_CellEmployee(select_employee,select_workcell);
            model.addAttribute("cellEmployee",cellEmployee);
        }
        return "cellemployee_list";
    }
    @RequestMapping(value = "/insert_cellemployee",method = RequestMethod.POST)
    public String addCellEmployee(String id,String employee_id,String cell_id){
        CellEmployee cellEmployee=new CellEmployee();
        cellEmployee.setEmployee_id(employee_id);
        cellEmployee.setCell_id(cell_id);
        cellEmployee.setDel_flag("0");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(!id.equals("")){
            cellEmployee.setId(id);
            cellEmployee.setUpdate_date(dateFormat.format(date));
            cellEmployeeService.update_CellEmployee(cellEmployee);
        }else {
            cellEmployee.setId(UUID.randomUUID().toString().replaceAll("-",""));
            cellEmployee.setCreate_date(dateFormat.format(date));
            cellEmployee.setUpdate_date(dateFormat.format(date));
            cellEmployeeService.insert_CellEmployee(cellEmployee);
        }
        return "redirect:/cellemployee";
    }
    @GetMapping("/delete_cellemployee/{id}")
    public String deleteOneCompany(@PathVariable("id") String id){
        CellEmployee cellEmployee=cellEmployeeService.select_ById(id);
        cellEmployee.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cellEmployee.setUpdate_date(dateFormat.format(date));
        cellEmployeeService.delete_CellEmployee(cellEmployee);
        return "redirect:/cellemployee";
    }
    @GetMapping("/update_cellemployee/{id}")
    public String updateOneCellEmployee(@PathVariable("id") String id,Model model){
        CellEmployee cellEmployee=cellEmployeeService.select_ById(id);
        WorkCell workCell=workCellService.select_ById(cellEmployee.getCell_id());
        List<WorkCell> otherWorkCellList=workCellService.other_Cell(cellEmployee.getCell_id());
        Employee employee=employeeService.select_ById(cellEmployee.getEmployee_id());
        model.addAttribute("employee",employee);
        model.addAttribute("otherWorkCellList",otherWorkCellList);
        model.addAttribute("workCell",workCell);
        model.addAttribute("cellEmployee",cellEmployee);
        model.addAttribute("cellemployee_id",id);
        return "cellemployee_form";
    }
    @RequestMapping("/form_cellemployee")
    public String formCellEmployee(Model model){
        List<WorkCell> workCellList=workCellService.all_WorkCell();
        List<Employee> employeeList=employeeService.other_Employee();
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("workCellList",workCellList);
        return "cellemployee_form";
    }
}
