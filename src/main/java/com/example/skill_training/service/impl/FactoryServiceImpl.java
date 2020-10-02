package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Factory;
import com.example.skill_training.mapper.FactoryMapper;
import com.example.skill_training.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    FactoryMapper factoryMapper;
    @Override
    public List<Factory> all_Factory() {
        return factoryMapper.allFactory();
    }

    @Override
    public Factory one_Factory(String factoryName) {
        return factoryMapper.oneFactory(factoryName);
    }

    @Override
    public Factory select_ById(String id) {
        return factoryMapper.selectById(id);
    }

    @Override
    public List<Factory> other_Factory(String id) {
        return factoryMapper.otherFactory(id);
    }

    @Override
    public boolean insert_Factory(Factory factory) {
        return factoryMapper.insertFactory(factory);
    }

    @Override
    public boolean delete_Factory(String factoryName) {
        return factoryMapper.deleteFactory(factoryName);
    }

    @Override
    public boolean update_Factory(Factory factory) {
        return factoryMapper.updateFactory(factory);
    }
}
