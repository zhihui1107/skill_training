package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Order;
import com.example.skill_training.mapper.OrderMapper;
import com.example.skill_training.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> all_Order() {
        return orderMapper.allOrder();
    }

    @Override
    public Order select_ById(String id) {
        return orderMapper.selectById(id);
    }

    @Override
    public Order select_ByOrderNo(String orderNo) {
        return orderMapper.selectByOrderNo(orderNo);
    }

    @Override
    public boolean insert_Order(Order order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public boolean update_Status(Order order) {
        return orderMapper.updateStatus(order);
    }
}
