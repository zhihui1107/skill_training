package com.example.skill_training.controller;

import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.service.WorkCellService;
import com.example.skill_training.service.WorkStationService;
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
public class WorkCellController {
    @Autowired
    WorkCellService workCellService;
    @Autowired
    WorkStationService workStationService;
    @RequestMapping("/workcell")
    public String getAllWorkCell(Model model){
        List<WorkCell> workCellList=workCellService.all_WorkCell();
        model.addAttribute("workCellList",workCellList);
        return "workcell_list";
    }
    @RequestMapping(value = "/oneWorkCell",method = RequestMethod.POST)
    public String getOneWorkCell(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/workcell";
        }else {
            WorkCell workCell=workCellService.one_WorkCell(select_name);
            if(workCell==null){

            }else {
                WorkStation workStation=workStationService.select_ById(workCell.getStation_id());
                workCell.setStation_id(workStation.getStationName());
            }
            model.addAttribute("workCell",workCell);
            return "workcell_list";
        }
    }
    @RequestMapping(value = "/insert_workcell",method = RequestMethod.POST)
    public String addWorkCell(String id,String cellName,String cellNumber,String cellMaster,String cellDescription,String station_id){
        WorkCell workCell=new WorkCell();
        workCell.setCellName(cellName);
        workCell.setCellNumber(cellNumber);
        workCell.setCellMaster(cellMaster);
        workCell.setCellDescription(cellDescription);
        workCell.setStation_id(station_id);
        workCell.setDel_flag("0");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(!id.equals("")){
            workCell.setId(id);
            workCell.setUpdate_date(dateFormat.format(date));
            workCellService.update_WorkCell(workCell);
        }else {
            workCell.setId(UUID.randomUUID().toString().replaceAll("-",""));
            workCell.setCreate_date(dateFormat.format(date));
            workCell.setUpdate_date(dateFormat.format(date));
            workCellService.insert_WorkCell(workCell);
        }
        return "redirect:/workcell";
    }
    @GetMapping("/delete_workcell/{id}")
    public String deleteOneWorkCell(@PathVariable("id") String id){
        WorkCell workCell=workCellService.select_ById(id);
        workCell.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workCell.setUpdate_date(dateFormat.format(date));
        workCellService.delete_WorkCell(workCell);
        return "redirect:/workcell";
    }
    @GetMapping("/update_workcell/{id}")
    public String updateOneWorkCell(@PathVariable("id") String id,Model model){
        WorkCell workCell=workCellService.select_ById(id);
        WorkStation workStation=workStationService.select_ById(workCell.getStation_id());
        List<WorkStation> otherWorkStationList=workStationService.other_WorkStation(workCell.getStation_id());
        model.addAttribute("workStation",workStation);
        model.addAttribute("otherWorkStationList",otherWorkStationList);
        model.addAttribute("workCell",workCell);
        model.addAttribute("workcell_id",id);
        return "workcell_form";
    }
    @RequestMapping("/form_workcell")
    public String formWorkCell(Model model){
        List<WorkStation> workStationList=workStationService.all_WorkStation();
        model.addAttribute("workStationList",workStationList);
        return "workcell_form";
    }
}
