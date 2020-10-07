package com.example.skill_training.controller;

import com.example.skill_training.entity.Company;
import com.example.skill_training.service.CompanyService;
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
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/company")
    public String getAllCompany(Model model){
        List<Company> companyList=companyService.all_Company();
        model.addAttribute("companyList",companyList);
        return "company_list";
    }
    @RequestMapping(value = "/oneCompany",method = RequestMethod.POST)
    public String getOneCompany(String select_name,Model model){
        if(select_name.equals("")){
            return "redirect:/company";
        }else {
            Company company=companyService.one_Company(select_name);
            model.addAttribute("company",company);
            return "company_list";
        }
    }
    @RequestMapping(value = "/insert_company",method = RequestMethod.POST)
    public String addCompany(String id,String enterName,String enterCode,String enterLevel,String enterNature,String enterCapital,
                             String enterLperson,String enterLpCard,String enterAddress,String emailCode,String enterRemarks){
        Company company=new Company();
        company.setEnterName(enterName);
        company.setEnterCode(enterCode);
        company.setEnterLevel(enterLevel);
        company.setEnterNature(enterNature);
        company.setEnterCapital(enterCapital);
        company.setEnterLperson(enterLperson);
        company.setEnterLpCard(enterLpCard);
        company.setEnterAddress(enterAddress);
        company.setEmailCode(emailCode);
        company.setEnterRemarks(enterRemarks);
        company.setDel_flag("0");
        Date date=new Date();//获取一个Date对象
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//创建格式化日期对象
        if(!id.equals("")){
            company.setId(id);
            company.setUpdate_date(dateFormat.format(date));
            companyService.update_Company(company);
        }else {
            company.setCreate_date(dateFormat.format(date));//格式化后的时间
            company.setId(UUID.randomUUID().toString().replaceAll("-",""));
            company.setUpdate_date(dateFormat.format(date));
            companyService.insert_Company(company);
        }
        return "redirect:/company";
    }
    @GetMapping("/delete_company/{id}")
    public String deleteOneCompany(@PathVariable("id") String id){
        Company company=companyService.select_ById(id);
        company.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        company.setUpdate_date(dateFormat.format(date));
        companyService.delete_Company(company);
        return "redirect:/company";
    }
    @GetMapping("/update_company/{id}")
    public String updateOneCompany(@PathVariable("id") String id,Model model){
        Company company=companyService.select_ById(id);
        model.addAttribute("company",company);
        model.addAttribute("own_id",id);
        return "company_form";
    }
    @RequestMapping("/form_company")
    public String formCompany(){
        return "company_form";
    }
}
