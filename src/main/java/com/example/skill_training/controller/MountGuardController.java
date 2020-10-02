package com.example.skill_training.controller;

import com.example.skill_training.entity.MountGuard;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.service.MountGuardService;
import com.example.skill_training.service.WorkCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MountGuardController {
    @Autowired
    MountGuardService mountGuardService;
    @Autowired
    WorkCellService workCellService;
    @RequestMapping("/mountguard")
    public String getAllMountGuard(Model model){
        List<MountGuard> mountGuardList=mountGuardService.all_MountGuard();
        List<WorkCell> workCellList=workCellService.all_WorkCell();
        model.addAttribute("workCellList",workCellList);
        model.addAttribute("mountGuardList",mountGuardList);
        return "mount_guard";
    }
    @RequestMapping(value = "/oneMountGuard",method = RequestMethod.POST)
    public String getOneMountGuard(String employeeNo,String cellName,String workStatus,Model model){
        List<MountGuard> mountGuardList=new ManagedList<>();
        if(employeeNo.equals("")&&cellName.equals("")&&workStatus.equals("")){
            return "redirect:/mountguard";
        }else if(employeeNo.equals("")&&cellName.equals("")){
            mountGuardList=mountGuardService.selectBy_WorkStatus(workStatus);
        }else if(employeeNo.equals("")&&workStatus.equals("")){
            mountGuardList=mountGuardService.selectBy_CellName(cellName);
        }else if(cellName.equals("")&&workStatus.equals("")){
            mountGuardList=mountGuardService.selectBy_EmployeeNo(employeeNo);
        }else if(employeeNo.equals("")){
            mountGuardList=mountGuardService.selectNotBy_EmployeeNo(cellName, workStatus);
        }else if(cellName.equals("")){
            mountGuardList=mountGuardService.selectNotBy_CellName(employeeNo, workStatus);
        }else if(workStatus.equals("")){
            mountGuardList=mountGuardService.selectNotBy_WorkStatus(employeeNo, cellName);
        }else {
            mountGuardList=mountGuardService.selectOne_Employee(employeeNo, cellName, workStatus);
        }
        List<WorkCell> workCellList=workCellService.all_WorkCell();
        model.addAttribute("workCellList",workCellList);
        model.addAttribute("mountGuardList",mountGuardList);
        return "mount_guard";
    }
}
