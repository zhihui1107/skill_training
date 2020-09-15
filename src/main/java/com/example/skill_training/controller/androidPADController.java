package com.example.skill_training.controller;

import com.example.skill_training.entity.androidPAD;
import com.example.skill_training.service.androidPADService;
import com.sun.org.apache.xpath.internal.operations.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Controller
public class androidPADController {
    @Autowired
    private androidPADService AndroidPADService;

    @RequestMapping("/androidPADs")
    public String get_All(Model model){
        List<androidPAD> androidPADs =AndroidPADService.getAll();
        model.addAttribute("androidPADs",androidPADs);
        return "androidlist";
    }

    @GetMapping("/deletePAD/{id}")
    public String DeletePAD(@PathVariable("id") String id){
        AndroidPADService.deleteandroidPAD(id);
        return "redirect:/androidPADs";
    }

    @RequestMapping(value = "/Add",method = RequestMethod.POST)
    public String addPAD(String id,String type,String spec,String station,String cell,String pADsc,String pADNucleus,String pADMemory,
    String capacity,String supplier,String manufacturer,String factoryNumber,String purpose,String buyDate,String person,String organization,String remarks){
        androidPAD AndroidPAD =new androidPAD();
        AndroidPAD.setId(id);
        AndroidPAD.setType(type);
        AndroidPAD.setSpec(spec);
        AndroidPAD.setStation_id(station);
        AndroidPAD.setCell_id(cell);
        AndroidPAD.setpADsc(pADsc);
        AndroidPAD.setpADNucleus(pADNucleus);
        AndroidPAD.setpADMemory(pADMemory);
        AndroidPAD.setCapacity(capacity);
        AndroidPAD.setSupplier(supplier);
        AndroidPAD.setManufacturer(manufacturer);
        AndroidPAD.setFactoryNumber(factoryNumber);
        AndroidPAD.setPurpose(purpose);
        AndroidPAD.setBuyDate(buyDate);
        AndroidPAD.setPerson(person);
        AndroidPAD.setOrganization(organization);
        AndroidPAD.setRemarks(remarks);
        AndroidPAD.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
        AndroidPAD.setCreate_date(getcreateTime());

        AndroidPADService.addandroidPAD(AndroidPAD);
        return "redirect:/androidPADs";
    }

    @RequestMapping(value = "/Search",method = RequestMethod.POST)
    public String Search_PAD(String search_type,String search_spec,String search_id,Model model){
            if(search_id.equals("")||search_type.equals("")||search_spec.equals("")){
                List<androidPAD> androidPADs =AndroidPADService.getAll();
                model.addAttribute("androidPADs",androidPADs);
                return "androidList";
            }
            else {
                androidPAD AndroidPAD=AndroidPADService.Search_PAD(search_spec,search_id,search_type);
                model.addAttribute("androidPAD",AndroidPAD);
                return "androidList";
            }
    }




    /*生成设备唯一代码 qrCode*/
    public static String getqrTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        return sdfTime.format(new Date());
    }

    /*生成创建时间*/
    public static String getcreateTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        return sdfTime.format(new Date());
    }

}
