package com.example.skill_training.service;

import com.example.skill_training.entity.WorkOrder;

import java.util.List;

public interface WorkOrderService {
    List<WorkOrder> all_WorkOrder();
    List<WorkOrder> selectBy_OrderCode(String orderCode);
    WorkOrder selectBy_Id(String id);
    boolean insert_OneWorkOrder(WorkOrder workOrder);
    boolean update_WorkOrder(WorkOrder workOrder);
    boolean delete_WorkOrder(WorkOrder workOrder);
}
