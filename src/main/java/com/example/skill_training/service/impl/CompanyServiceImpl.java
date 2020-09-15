package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Company;
import com.example.skill_training.mapper.CompanyMapper;
import com.example.skill_training.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public List<Company> all_Company(){
        return companyMapper.allCompany();
    }

    @Override
    public Company one_Company(String enterName) {
        return companyMapper.oneCompany(enterName);
    }

    @Override
    public Company select_ById(int id) {
        return companyMapper.selectById(id);
    }

    @Override
    public boolean insert_Company(Company company){
        companyMapper.insertCompany(company);
        return true;
    }
    @Override
    public boolean delete_Company(String enterName){
        companyMapper.deleteCompany(enterName);
        return true;
    }

    @Override
    public boolean update_Company(Company company) {
        companyMapper.updateCompany(company);
        return true;
    }
}
