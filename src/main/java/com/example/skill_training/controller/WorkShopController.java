package com.example.skill_training.controller;

import com.example.skill_training.entity.Factory;
import com.example.skill_training.entity.WorkShop;
import com.example.skill_training.service.FactoryService;
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
public class WorkShopController {
    @Autowired
    private WorkShopService workShopService;
    @Autowired
    private FactoryService factoryService;
    @RequestMapping("/workshop")
    public String getAllWorkShop(Model model){
        List<WorkShop> workShopList=workShopService.all_WorkShop();
        model.addAttribute("workShopList",workShopList);
        return "workshop_list";
    }
    @RequestMapping(value = "/oneWorkShop",method = RequestMethod.POST)
    public String getOneWorkShop(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/workshop";
        }else {
            WorkShop workShop=workShopService.one_WorkShop(select_name);
            if(workShop==null){

            }else {
                Factory factory=factoryService.select_ById(workShop.getFactory_id());
                workShop.setFactory_id(factory.getFactoryName());
            }
            model.addAttribute("workShop",workShop);
            return "workshop_list";
        }
    }
    @RequestMapping(value = "/insert_workshop",method = RequestMethod.POST)
    public String addWorkShop(String id,String shopName,String shopNo,String master,String description,String factory_id){
        WorkShop workShop=new WorkShop();
        workShop.setShopName(shopName);
        workShop.setShopNo(shopNo);
        workShop.setMaster(master);
        workShop.setDescription(description);
        workShop.setFactory_id(factory_id);
        workShop.setDel_flag("0");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!id.equals("")){
            workShop.setId(id);
            workShop.setUpdate_date(dateFormat.format(date));
            workShopService.update_WorkShop(workShop);
        }else {
            workShop.setId(UUID.randomUUID().toString().replaceAll("-",""));
            workShop.setCreate_date(dateFormat.format(date));
            workShop.setUpdate_date(dateFormat.format(date));
            workShopService.insert_WorkShop(workShop);
        }
        return "redirect:/workshop";
    }
    @GetMapping("/delete_workshop/{id}")
    public String deleteOneCompany(@PathVariable("id") String id){
        WorkShop workShop=workShopService.select_ById(id);
        workShop.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workShop.setUpdate_date(dateFormat.format(date));
        workShopService.delete_WorkShop(workShop);
        return "redirect:/workshop";
    }
    @GetMapping("/update_workshop/{id}")
    public String updateOneWorkShop(@PathVariable("id") String id,Model model){
        WorkShop workShop=workShopService.select_ById(id);
        Factory factory=factoryService.select_ById(workShop.getFactory_id());
        List<Factory> otherFactoryList=factoryService.other_Factory(workShop.getFactory_id());
        model.addAttribute("factory",factory);
        model.addAttribute("otherFactoryList",otherFactoryList);
        model.addAttribute("workShop",workShop);
        model.addAttribute("workshop_id",id);
        return "workshop_form";
    }
    @RequestMapping("/form_workshop")
    public String formWorkShop(Model model){
        List<Factory> factoryList=factoryService.all_Factory();
        model.addAttribute("factoryList",factoryList);
        return "workshop_form";
    }
}
