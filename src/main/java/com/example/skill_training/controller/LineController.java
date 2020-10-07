package com.example.skill_training.controller;

import com.example.skill_training.entity.Line;
import com.example.skill_training.entity.WorkShop;
import com.example.skill_training.service.LineService;
import com.example.skill_training.service.WorkShopService;
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
public class LineController {
    @Autowired
    LineService lineService;
    @Autowired
    WorkShopService workShopService;
    @RequestMapping("/line")
    public String getAllLine(Model model){
        List<Line> lineList=lineService.all_Line();
        model.addAttribute("lineList",lineList);
        return "line_list";
    }
    @RequestMapping(value = "/oneLine",method = RequestMethod.POST)
    public String getOneLine(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/line";
        }else {
            Line line=lineService.one_Line(select_name);
            if(line==null){

            }else {
                WorkShop workShop=workShopService.select_ById(line.getWorkshop_id());
                line.setWorkshop_id(workShop.getShopName());
            }
            model.addAttribute("line",line);
            return "line_list";
        }
    }
    @RequestMapping(value = "/insert_line",method = RequestMethod.POST)
    public String addLine(String id,String lineName,String lineNumber,String lineMaster,String lineDescription,String workshop_id){
        Line line=new Line();
        line.setLineName(lineName);
        line.setLineNumber(lineNumber);
        line.setLineMaster(lineMaster);
        line.setLineDescription(lineDescription);
        line.setWorkshop_id(workshop_id);
        line.setDel_flag("0");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!id.equals("")){
            line.setId(id);
            line.setUpdate_date(dateFormat.format(date));
            lineService.update_Line(line);
        }else {
            line.setId(UUID.randomUUID().toString().replaceAll("-",""));
            line.setCreate_date(dateFormat.format(date));
            line.setUpdate_date(dateFormat.format(date));
            lineService.insert_Line(line);
        }
        return "redirect:/line";
    }
    @GetMapping("/delete_line/{id}")
    public String deleteOneLine(@PathVariable("id") String id){
        Line line=lineService.select_ById(id);
        line.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        line.setUpdate_date(dateFormat.format(date));
        lineService.delete_Line(line);
        return "redirect:/line";
    }
    @GetMapping("/update_line/{id}")
    public String updateOneLine(@PathVariable("id") String id,Model model){
        Line line=lineService.select_ById(id);
        WorkShop workShop=workShopService.select_ById(line.getWorkshop_id());
        List<WorkShop> otherWorkShopList=workShopService.other_WorkShop(line.getWorkshop_id());
        model.addAttribute("workShop",workShop);
        model.addAttribute("otherWorkShopList",otherWorkShopList);
        model.addAttribute("line",line);
        model.addAttribute("line_id",id);
        return "line_form";
    }
    @RequestMapping("/form_line")
    public String formCompany(Model model){
        List<WorkShop> workShopList=workShopService.all_WorkShop();
        model.addAttribute("workShopList",workShopList);
        return "line_form";
    }
}
