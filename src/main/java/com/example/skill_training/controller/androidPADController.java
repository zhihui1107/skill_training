package com.example.skill_training.controller;


import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.entity.androidPAD;
import com.example.skill_training.service.DictionaryService;
import com.example.skill_training.service.EquipCommonService;
import com.example.skill_training.service.androidPADService;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Controller
public class androidPADController {
    @Autowired
    private androidPADService AndroidPADService;
    @Autowired
    private EquipCommonService equipCommonService;
    @Autowired
    private DictionaryService dictionaryService;

    /*1.显示所有安卓PAD设备*/
    @RequestMapping("/androidPADs")
    public String get_All(Model model){
        List<androidPAD> androidPADs =AndroidPADService.getAllandroidPAD();
        model.addAttribute("androidPADs",androidPADs);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "androidList";
    }

    /*2.删除安卓PAD设备*/
    @GetMapping("/deletePAD/{id}")
    public String DeletePAD(@PathVariable("id") String id){
        AndroidPADService.deleteandroidPAD(id);
        return "redirect:/androidPADs";
    }

    /*3.添加安卓PAD设备*/
    @RequestMapping(value = "/AddPAD",method = RequestMethod.POST)
    public String addPAD(String id, String qrCode, String type, String spec, String station, String cell, String pADsc, String pADNucleus, String pADMemory,
                         String capacity, String supplier, String manufacturer, String factoryNumber, String purpose, String buyDate, String person, String organization, String remarks, HttpSession session){

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


        if(!qrCode.equals("")){
            AndroidPAD.setQrCode(qrCode);
            AndroidPAD.setUpdate_by(session.getAttribute("id").toString());
            AndroidPAD.setUpdate_date(getcreateTime());
            AndroidPADService.updateandroidPAD(AndroidPAD);;
        }else {
            AndroidPAD.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
            AndroidPAD.setCreate_by(session.getAttribute("id").toString());
            AndroidPAD.setCreate_date(getcreateTime());
            AndroidPAD.setUpdate_by(session.getAttribute("id").toString());
            AndroidPAD.setUpdate_date(getcreateTime());
            AndroidPAD.setDel_flag("0");
            AndroidPADService.addandroidPAD(AndroidPAD);
        }
        return "redirect:/androidPADs";
    }

    /*4.修改安卓PAD设备信息*/
    @GetMapping("/updatePAD/{qrCode}")
    public String updatePAD(@PathVariable("qrCode") String qrCode,Model model){
        model.addAttribute("own_qrCode",qrCode);

        androidPAD Android=AndroidPADService.Search_PADByq(qrCode);
        model.addAttribute("Android",Android);

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "androidForm";
    }

    /*5.跳转到添加修改界面*/
    @RequestMapping("/androidPAD_form")
    public String form(androidPAD androidPAD,Model model){
//        List<androidPAD> AndroidList=AndroidPADService.getAllandroidPAD();
//        model.addAttribute("androidList",AndroidList);
        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "androidForm";
    }
    /*6.根据条件搜索安卓PAD设备*/
    @RequestMapping(value = "/SearchPAD",method = RequestMethod.POST)
    public String Search_PAD(String search_type,String search_spec,String search_id,Model model){
            if(search_id.equals("")&&search_type.equals("")&&search_spec.equals("")){
                List<androidPAD> androidPADs =AndroidPADService.getAllandroidPAD();
                model.addAttribute("androidPADs",androidPADs);
                return "androidList";
            }
            else {
                if (!search_spec.equals("")){
                    if (search_id.equals("")){
                        if (search_type.equals("")){
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADBys(search_spec);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                        else {
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADByst(search_spec,search_type);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                    }
                    else {
                        if (search_type.equals("")){
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADBysi(search_spec,search_id);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                        else {
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADBysit(search_spec,search_id,search_type);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                    }
                }
                else {
                    if (search_id.equals("")){
                        List<androidPAD> AndroidPAD=AndroidPADService.Search_PADByt(search_type);
                        model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                    }
                    else {
                        if(search_type.equals("")){
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADByi(search_id);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                        else {
                            List<androidPAD> AndroidPAD=AndroidPADService.Search_PADByit(search_id,search_type);
                            model.addAttribute("androidPADs",AndroidPAD);
//                            return "androidList";
                        }
                    }
                }
            }
        return "androidList";
    }

    /*7.生成设备唯一代码 qrCode*/
    public static String getqrTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        return sdfTime.format(new Date());
    }

    /*8.生成创建或修改时间*/
    public static String getcreateTime() {
        SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("时间戳："+sdfTime.format(new Date()));
        return sdfTime.format(new Date());
    }

}
