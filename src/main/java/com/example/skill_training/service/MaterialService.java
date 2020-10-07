package com.example.skill_training.service;

import com.example.skill_training.entity.Material;

import java.util.List;

public interface MaterialService {
    Material find_Sum(Material material);
    List<Material> find_List(Material material);
    boolean save_Material(Material material);
}
