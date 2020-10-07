package com.example.skill_training.service.impl;

import com.example.skill_training.entity.BomDetail;
import com.example.skill_training.mapper.BomDetailMapper;
import com.example.skill_training.service.BomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BomDetailServiceImpl implements BomDetailService {
    @Autowired
    BomDetailMapper bomDetailMapper;
    @Override
    public List<BomDetail> all_BomDetail(String bom_id) {
        return bomDetailMapper.allBomDetail(bom_id);
    }
}
