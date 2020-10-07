package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Material;
import com.example.skill_training.mapper.MaterialMapper;
import com.example.skill_training.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    @Override
    public Material find_Sum(Material material) {
        return materialMapper.findSum(material);
    }

    @Override
    public List<Material> find_List(Material material) {
        return materialMapper.findList(material);
    }

    @Override
    public boolean save_Material(Material material) {
        return materialMapper.saveMaterial(material);
    }

}
