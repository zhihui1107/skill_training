package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Bom;
import com.example.skill_training.mapper.BomMapper;
import com.example.skill_training.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BomServiceImpl implements BomService {
    @Autowired
    BomMapper bomMapper;
    @Override
    public Bom select_ByProduct_Id(String product_id) {
        return bomMapper.selectByProduct_Id(product_id);
    }
}
