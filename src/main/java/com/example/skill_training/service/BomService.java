package com.example.skill_training.service;

import com.example.skill_training.entity.Bom;

public interface BomService {
    Bom select_ByProduct_Id(String product_id);
}
