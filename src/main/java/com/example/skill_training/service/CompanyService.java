package com.example.skill_training.service;

import com.example.skill_training.entity.Company;

import java.util.List;

public interface CompanyService {
    List<Company> all_Company();
    Company one_Company(String enterName);
    Company select_ById(int id);
    boolean insert_Company(Company company);
    boolean delete_Company(String enterName);
    boolean update_Company(Company company);
}
