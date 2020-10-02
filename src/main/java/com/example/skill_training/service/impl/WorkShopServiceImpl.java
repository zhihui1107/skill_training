package com.example.skill_training.service.impl;

import com.example.skill_training.entity.WorkShop;
import com.example.skill_training.mapper.WorkShopMapper;
import com.example.skill_training.service.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkShopServiceImpl implements WorkShopService {
    @Autowired
    WorkShopMapper workShopMapper;
    @Override
    public List<WorkShop> all_WorkShop() {
        return workShopMapper.allWorkShop();
    }

    @Override
    public WorkShop one_WorkShop(String shopName) {
        return workShopMapper.oneWorkShop(shopName);
    }

    @Override
    public WorkShop select_ById(String id) {
        return workShopMapper.selectById(id);
    }

    @Override
    public List<WorkShop> other_WorkShop(String id) {
        return workShopMapper.otherWorkShop(id);
    }

    @Override
    public boolean insert_WorkShop(WorkShop workShop) {
        return workShopMapper.insertWorkShop(workShop);
    }

    @Override
    public boolean delete_WorkShop(String shopName) {
        return workShopMapper.deleteWorkShop(shopName);
    }

    @Override
    public boolean update_WorkShop(WorkShop workShop) {
        return workShopMapper.updateWorkShop(workShop);
    }
}
