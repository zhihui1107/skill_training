package com.example.skill_training.controller;

import com.example.skill_training.entity.*;
import com.example.skill_training.entity.Process;
import com.example.skill_training.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class WorkOrderController {
    @Autowired
    WorkOrderService workOrderService;
    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    LineService lineService;
    @Autowired
    ProductService productService;
    @Autowired
    BomService bomService;
    @Autowired
    BomDetailService bomDetailService;
    @Autowired
    FlowService flowService;
    @Autowired
    ProcessService processService;
    @Autowired
    FlowProcessService flowProcessService;
    @Autowired
    MaterialService materialService;
    @Autowired
    OrderService orderService;
    @RequestMapping("/work_order")
    public String getAllWorkOrder(Model model){
        List<WorkOrder> workOrderList=workOrderService.all_WorkOrder();
        for(WorkOrder workOrder:workOrderList){
            workOrder.setLine_id(lineService.oneLineName(workOrder.getLine_id()).getLineName());
            workOrder.setProduct_id(productService.select_ById(workOrder.getProduct_id()).getProductName());
            workOrder.setUnitName(dictionaryService.select_OneType("unit",workOrder.getUnitName()).getLabel());
            workOrder.setState(dictionaryService.select_OneType("workorder_state",workOrder.getState()).getLabel());
        }
        model.addAttribute("workOrderList",workOrderList);
        return "work_order_list";
    }
    @RequestMapping(value = "/oneWorkOrder",method = RequestMethod.POST)
    public String getOneWorkOrder(String orderCode,Model model){
        if(orderCode.equals("")){
            return "redirect:/work_order";
        }else {
            List<WorkOrder> workOrderList=workOrderService.selectBy_OrderCode(orderCode);
            if(workOrderList==null){

            }else {
                for(WorkOrder workOrder:workOrderList){
                    workOrder.setUnitName(dictionaryService.select_OneType("unit",workOrder.getUnitName()).getLabel());
                    workOrder.setState(dictionaryService.select_OneType("workorder_state",workOrder.getState()).getLabel());
                }
            }
            model.addAttribute("workOrderList",workOrderList);
            return "work_order_list";
        }
    }
    @RequestMapping(value = "/insert_one_work_order",method = RequestMethod.POST)
    public String insertOneWorkOrder(String id,String orderCode,String order_id,String orderType,int amount,String unitName,
                                     String estStartTime,String estEndTime,String actStartTime,int inAmount,
                                     int outAmount,int scrapAmount,String state,String line_id,String product_id){

        WorkOrder workOrder=new WorkOrder();
        workOrder.setOrderCode(orderCode);
        workOrder.setOrder_id(order_id);
        workOrder.setOrderType(orderType);
        workOrder.setAmount(amount);
        workOrder.setUnitName(dictionaryService.select_OneValue("unit",unitName).getValue());
        workOrder.setEstStartTime(estStartTime);
        workOrder.setEstEndTime(estEndTime);
        workOrder.setActStartTime(actStartTime);
        workOrder.setInAmount(inAmount);
        workOrder.setOutAmount(outAmount);
        workOrder.setScrapAmount(scrapAmount);
        workOrder.setState(state);
        workOrder.setLine_id(line_id);
        workOrder.setProduct_id(productService.select_ByProductName(product_id).getId());
        workOrder.setDel_flag("0");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(!id.equals("")){
            workOrder.setId(id);
            workOrder.setUpdate_date(dateFormat.format(date));
            workOrderService.update_WorkOrder(workOrder);
        }else {
            Bom bom=bomService.select_ByProduct_Id(productService.select_ByProductName(product_id).getId());
            List<BomDetail> bomDetailList=bomDetailService.all_BomDetail(bom.getId());
            double nums=0;//存放海鲜总重量或袋子总数量
            double curSum=0;//某类型原料总数
            int allNums=amount*24;//工单中生产产品的袋数，一箱24袋bag开头是包装袋fresh开头是主料
            for(BomDetail bomDetail1:bomDetailList){
                //获得物料对应的原料总数和每批次原料的集合
                Material material=new Material();
                material.setmType(bomDetail1.getmType());
                curSum=materialService.find_Sum(material).getSum();
                List<Material> materialList=materialService.find_List(material);
                //当前工单所需的物料数量
                if(bomDetail1.getmType().indexOf("bag")>-1 ||bomDetail1.getmType().indexOf("fresh")>-1){
                    nums=allNums*bomDetail1.getmNum();
                }
                //判断库存与所需大小
                if(curSum<nums){
                    return "redirect:/order";
                }
                for (Material material1:materialList){
                    if(material1.getQuantity()>=nums){
                        material1.setQuantity(material1.getQuantity()-nums);
                        materialService.save_Material(material1);
                        break;
                    }
                    nums=nums-material1.getQuantity();
                    material1.setQuantity(0);
                    materialService.save_Material(material1);
                }
            }
            Order order=orderService.select_ByOrderNo(order_id);
            order.setStatus("workOrder");
            orderService.update_Status(order);
            workOrder.setId(UUID.randomUUID().toString().replaceAll("-",""));
            workOrder.setCreate_date(dateFormat.format(date));
            workOrder.setUpdate_date(dateFormat.format(date));
            workOrderService.insert_OneWorkOrder(workOrder);
        }
        return "redirect:/order";
    }
    @GetMapping("/update_work_order/{id}")
    public String updateWorkOrder(@PathVariable("id") String id,Model model){
        WorkOrder workOrder=workOrderService.selectBy_Id(id);
        workOrder.setProduct_id(productService.select_ById(workOrder.getProduct_id()).getProductName());
        workOrder.setUnitName(dictionaryService.select_OneType("unit",workOrder.getUnitName()).getLabel());
        Dictionary dictionary_type=dictionaryService.select_OneType("workorder_type",workOrder.getOrderType());
        Dictionary dictionary_state=dictionaryService.select_OneType("workorder_state",workOrder.getState());
        List<Dictionary> otherTypeList=dictionaryService.otherType("workorder_type",workOrder.getOrderType());
        List<Dictionary> otherStateList=dictionaryService.otherType("workorder_state",workOrder.getState());
        Line line=lineService.oneLineName(workOrder.getLine_id());
        List<Line> otherLineList=lineService.other_Line(line.getId());
        model.addAttribute("update_work_order_id",id);
        model.addAttribute("dictionary_type",dictionary_type);
        model.addAttribute("dictionary_state",dictionary_state);
        model.addAttribute("workOrder",workOrder);
        model.addAttribute("update_work_order_id",id);
        model.addAttribute("otherTypeList",otherTypeList);
        model.addAttribute("otherStateList",otherStateList);
        model.addAttribute("line",line);
        model.addAttribute("otherLineList",otherLineList);
        return "work_order_form";
    }
    @GetMapping("/delete_work_order/{id}")
    public String deleteWorkOrder(@PathVariable("id") String id){
        WorkOrder workOrder=workOrderService.selectBy_Id(id);
        workOrder.setDel_flag("1");
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workOrder.setUpdate_date(dateFormat.format(date));
        workOrderService.delete_WorkOrder(workOrder);
        return "redirect:/work_order";
    }
    @GetMapping("/select_bom/{id}")
    public String selectBom(@PathVariable("id") String id,Model model){
        WorkOrder workOrder=workOrderService.selectBy_Id(id);
        Bom bom=bomService.select_ByProduct_Id(workOrder.getProduct_id());
        workOrder.setProduct_id(productService.select_ById(workOrder.getProduct_id()).getProductName());
        List<BomDetail> bomDetailList=bomDetailService.all_BomDetail(bom.getId());
        for(BomDetail bomDetail:bomDetailList){
            bomDetail.setmType(dictionaryService.select_OneType("material_type",bomDetail.getmType()).getLabel());
            bomDetail.setUnit(dictionaryService.select_OneType("unit",bomDetail.getUnit()).getLabel());
        }
        model.addAttribute("workOrder",workOrder);
        model.addAttribute("bom",bom);
        model.addAttribute("bomDetailList",bomDetailList);
        return "bom_detail";
    }
    @GetMapping("/select_process/{id}")
    public String selectProcess(@PathVariable("id") String id,Model model){
        WorkOrder workOrder=workOrderService.selectBy_Id(id);
        Product product=productService.select_ById(workOrder.getProduct_id());
        Flow flow=flowService.select_ById(product.getFlow_id());
        List<Process> processList=processService.select_ProcessById(workOrder.getProduct_id());
        workOrder.setProduct_id(product.getProductName());
        model.addAttribute("workOrder",workOrder);
        model.addAttribute("flow",flow);
        model.addAttribute("processList",processList);
        return "process_detail";
    }
}
