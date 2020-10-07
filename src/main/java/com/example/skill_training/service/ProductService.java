package com.example.skill_training.service;

import com.example.skill_training.entity.Product;

public interface ProductService {
    Product select_ById(String id);
    Product select_ByProductName(String productName);
}
