package com.example.skill_training.controller;

import com.example.skill_training.entity.Company;
import com.example.skill_training.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/company")
    public String getAllCompany(Model model){
        List<Company> companies=companyService.all_Company();
        model.addAttribute("companies",companies);
        return "company_list";
    }
    @RequestMapping(value = "/oneCompany",method = RequestMethod.POST)
    public String getOneCompany(String select_name,Model model){
        if(select_name.equals("")){
            List<Company> companies=companyService.all_Company();
            model.addAttribute("companies",companies);
            return "company_list";
            //return "redirect:/company";
        }else {
            Company company=companyService.one_Company(select_name);
            model.addAttribute("company1",company);
            return "company_list";
        }
    }
    @RequestMapping(value = "/insert_company",method = RequestMethod.POST)
    public String addCompany(int id,String enterName,String enterCode,String enterLevel,String enterNature,String enterCapital,
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
        if(companyService.select_ById(id)!=null){
            company.setId(id);
            companyService.update_Company(company);
        }else {
            companyService.insert_Company(company);
        }
        return "redirect:/company";
    }
    @GetMapping("/delete_company/{enterName}")
    public String deleteOneCompany(@PathVariable("enterName") String enterName){
        companyService.delete_Company(enterName);
        return "redirect:/company";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id,Model model){
        model.addAttribute("own_id",id);
        return "company_list";
    }
}
