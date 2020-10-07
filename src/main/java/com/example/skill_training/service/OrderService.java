package com.example.skill_training.service;

import com.example.skill_training.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> all_Order();
    Order select_ById(String id);
    Order select_ByOrderNo(String orderNo);
    boolean insert_Order(Order order);
    boolean update_Status(Order order);
}
