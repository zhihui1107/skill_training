package com.example.skill_training.service;

import com.example.skill_training.entity.Factory;

import java.util.List;

public interface FactoryService {
    List<Factory> all_Factory();
    Factory one_Factory(String factoryName);
    Factory select_ById(String id);
    List<Factory> other_Factory(String id);
    boolean insert_Factory(Factory factory);
    boolean delete_Factory(Factory factory);
    boolean update_Factory(Factory factory);
}
