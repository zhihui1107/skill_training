package com.example.skill_training.service;

import com.example.skill_training.entity.WorkShop;

import java.util.List;

public interface WorkShopService {
    List<WorkShop> all_WorkShop();
    WorkShop one_WorkShop(String shopName);
    WorkShop select_ById(String id);
    List<WorkShop> other_WorkShop(String id);
    boolean insert_WorkShop(WorkShop workShop);
    boolean delete_WorkShop(String shopName);
    boolean update_WorkShop(WorkShop workShop);
}
