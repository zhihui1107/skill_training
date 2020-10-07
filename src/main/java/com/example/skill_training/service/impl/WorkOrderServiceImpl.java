package com.example.skill_training.service.impl;

import com.example.skill_training.entity.WorkOrder;
import com.example.skill_training.mapper.WorkOrderMapper;
import com.example.skill_training.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {
    @Autowired
    WorkOrderMapper workOrderMapper;
    @Override
    public List<WorkOrder> all_WorkOrder() {
        return workOrderMapper.allWorkOrder();
    }

    @Override
    public List<WorkOrder> selectBy_OrderCode(String orderCode) {
        return workOrderMapper.selectByOrderCode(orderCode);
    }

    @Override
    public WorkOrder selectBy_Id(String id) {
        return workOrderMapper.selectById(id);
    }

    @Override
    public boolean insert_OneWorkOrder(WorkOrder workOrder) {
        return workOrderMapper.insertOneWorkOrder(workOrder);
    }

    @Override
    public boolean update_WorkOrder(WorkOrder workOrder) {
        return workOrderMapper.updateWorkOrder(workOrder);
    }

    @Override
    public boolean delete_WorkOrder(WorkOrder workOrder) {
        return workOrderMapper.deleteWorkOrder(workOrder);
    }
}
