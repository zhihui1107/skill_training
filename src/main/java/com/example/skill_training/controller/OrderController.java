package com.example.skill_training.controller;

import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.entity.Line;
import com.example.skill_training.entity.Order;
import com.example.skill_training.service.DictionaryService;
import com.example.skill_training.service.LineService;
import com.example.skill_training.service.OrderService;
import com.example.skill_training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    ProductService productService;
    @Autowired
    LineService lineService;
    @RequestMapping("/order")
    public String getAllOrder(Model model){
        List<Order> orderList=orderService.all_Order();
        for(Order order:orderList){
            order.setProduct_id(productService.select_ById(order.getProduct_id()).getProductName());
            order.setStatus(dictionaryService.select_OneType("order_status",order.getStatus()).getLabel());
        }
        model.addAttribute("orderList",orderList);
        return "order_list";
    }
    @GetMapping("/insert_order/{id}")
    public String insertOneOrder(@PathVariable("id") String id,Model model){
        Order order=orderService.select_ById(id);
        if(!order.getStatus().equals("newOrder")){
            return "redirect:/order";
        }else {
            order.setProduct_id(productService.select_ById(order.getProduct_id()).getProductName());
            List<Dictionary> workorder_typeList=dictionaryService.select_Type("workorder_type");
            List<Dictionary> workorder_stateList=dictionaryService.select_Type("workorder_state");
            Dictionary unit=dictionaryService.select_OneType("unit",order.getUnit());
            List<Line> lineList=lineService.all_Line();
            model.addAttribute("order",order);
            model.addAttribute("insert_work_order_id",id);
            model.addAttribute("workorder_typeList",workorder_typeList);
            model.addAttribute("workorder_stateList",workorder_stateList);
            model.addAttribute("unit",unit);
            model.addAttribute("lineList",lineList);
            return "work_order_form";
        }
    }
}
