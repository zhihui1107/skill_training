package com.example.skill_training.controller;

import com.example.skill_training.entity.Line;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.service.LineService;
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
public class WorkStationController {
    @Autowired
    private WorkStationService workStationService;
    @Autowired
    private LineService lineService;
    @RequestMapping("/workstation")
    public String getAllWorkStation(Model model){
        List<WorkStation> workStationList=workStationService.all_WorkStation();
        model.addAttribute("workStationList",workStationList);
        return "workstation_list";
    }
    @RequestMapping(value = "/oneWorkStation",method = RequestMethod.POST)
    public String getOneWorkStation(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/workstation";
        }else {
            WorkStation workStation=workStationService.one_WorkStation(select_name);
            Line line=lineService.select_ById(workStation.getLine_id());
            workStation.setLine_id(line.getLineName());
            model.addAttribute("workStation",workStation);
            return "workstation_list";
        }
    }
    @RequestMapping(value = "/insert_workstation",method = RequestMethod.POST)
    public String addWorkStation(String id,String stationName,String stationNo,String stationMaster,String line_id){
        WorkStation workStation=new WorkStation();
        workStation.setStationName(stationName);
        workStation.setStationNo(stationNo);
        workStation.setStationMaster(stationMaster);
        workStation.setLine_id(line_id);
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!id.equals("")){
            workStation.setId(id);
            workStation.setUpdate_date(dateFormat.format(date));
            workStationService.update_WorkStation(workStation);
        }else {
            workStation.setId(UUID.randomUUID().toString().replaceAll("-",""));
            workStation.setCreate_date(dateFormat.format(date));
            workStationService.insert_WorkStation(workStation);
        }
        return "redirect:/workstation";
    }
    @GetMapping("/delete_workstation/{stationName}")
    public String deleteOneWorkStation(@PathVariable("stationName") String stationName){
        workStationService.delete_WorkStation(stationName);
        return "redirect:/workstation";
    }
    @GetMapping("/update_workstation/{id}")
    public String updateOneCompany(@PathVariable("id") String id,Model model){
        WorkStation workStation=workStationService.select_ById(id);
        Line line=lineService.select_ById(workStation.getLine_id());
        List<Line> otherLineList=lineService.other_Line(workStation.getLine_id());
        model.addAttribute("line",line);
        model.addAttribute("otherLineList",otherLineList);
        model.addAttribute("workStation",workStation);
        model.addAttribute("workstation_id",id);
        return "workstation_form";
    }
    @RequestMapping("/form_workstation")
    public String formCompany(Model model){
        List<Line> lineList=lineService.all_Line();
        model.addAttribute("lineList",lineList);
        return "workstation_form";
    }
}
