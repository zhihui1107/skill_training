package com.example.skill_training.controller;

import com.example.skill_training.entity.Company;
import com.example.skill_training.entity.Factory;
import com.example.skill_training.service.CompanyService;
import com.example.skill_training.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class FactoryController {
    @Autowired
    FactoryService factoryService;
    @Autowired
    CompanyService companyService;
    @RequestMapping("/factory")
    public String getAllCompany(Model model){
        List<Factory> factoryList=factoryService.all_Factory();
        model.addAttribute("factoryList",factoryList);
        return "factory_list";
    }
    @RequestMapping(value = "/oneFactory",method = RequestMethod.POST)
    public String getOneFactory(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/factory";
        }else {
            Factory factory=factoryService.one_Factory(select_name);
            Company company=companyService.select_ById(factory.getEnterprise_id());
            factory.setEnterprise_id(company.getEnterName());
            model.addAttribute("factory",factory);
            return "factory_list";
        }
    }
    @RequestMapping(value = "/insert_factory",method = RequestMethod.POST)
    public String addFactory(String id,String factoryName,String factoryBuildDate,String factoryAddress,String factoryPhone,
                             String factoryECode,String factoryBuildM,String enterprise_id){
        Factory factory=new Factory();
        factory.setFactoryName(factoryName);
        factory.setFactoryBuildDate(factoryBuildDate);
        factory.setFactoryAddress(factoryAddress);
        factory.setFactoryPhone(factoryPhone);
        factory.setFactoryECode(factoryECode);
        factory.setFactoryBuildM(factoryBuildM);
        factory.setEnterprise_id(enterprise_id);
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!id.equals("")){
            factory.setId(id);
            factory.setUpdate_date(dateFormat.format(date));
            factoryService.update_Factory(factory);
        }else {
            factory.setId(UUID.randomUUID().toString().replaceAll("-",""));
            factory.setCreate_date(dateFormat.format(date));
            factoryService.insert_Factory(factory);
        }
        return "redirect:/factory";
    }
    @GetMapping("/delete_factory/{factoryName}")
    public String deleteOneFactory(@PathVariable("factoryName") String factoryName){
        factoryService.delete_Factory(factoryName);
        return "redirect:/factory";
    }
    @GetMapping("/update_factory/{id}")
    public String updateOneFactory(@PathVariable("id") String id, Model model){
        Factory factory=factoryService.select_ById(id);
        Company company=companyService.select_ById(factory.getEnterprise_id());
        List<Company> otherCompanyList=companyService.other_Company(factory.getEnterprise_id());
        model.addAttribute("otherCompanyList",otherCompanyList);
        model.addAttribute("company",company);
        model.addAttribute("factory",factory);
        model.addAttribute("factory_id",id);
        return "factory_form";
    }
    @RequestMapping("/form_factory")
    public String formFactory(Model model){
        List<Company> companyList=companyService.all_Company();
        model.addAttribute("companyList",companyList);
        return "factory_form";
    }
}
