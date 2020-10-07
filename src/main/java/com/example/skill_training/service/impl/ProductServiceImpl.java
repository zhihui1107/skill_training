package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Product;
import com.example.skill_training.mapper.ProductMapper;
import com.example.skill_training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Product select_ById(String id) {
        return productMapper.selectById(id);
    }

    @Override
    public Product select_ByProductName(String productName) {
        return productMapper.selectByProductName(productName);
    }
}
