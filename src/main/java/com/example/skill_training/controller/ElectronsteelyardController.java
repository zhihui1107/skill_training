package com.example.skill_training.controller;

import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.entity.Electronsteelyard;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.service.DictionaryService;
import com.example.skill_training.service.ElectronsteelyardService;
import com.example.skill_training.service.EquipCommonService;
import com.sun.org.apache.xpath.internal.operations.And;
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
public class ElectronsteelyardController {
    @Autowired
    private ElectronsteelyardService electronsteelyardService;
    @Autowired
    private EquipCommonService equipCommonService;
    @Autowired
    private DictionaryService dictionaryService;

    /*1.显示所有电子秤设备*/
    @RequestMapping("/Electronsteelyards")
    public String get_All(Model model){
        List<Electronsteelyard> electronsteelyards =electronsteelyardService.getAllElectronsteelyard();
        model.addAttribute("electronsteelyards",electronsteelyards);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "ElectronsteelyardList";
    }

    /*2.删除电子秤设备*/
    @GetMapping("/deleteElectronsteelyard/{id}")
    public String DeleteElectronsteelyard(@PathVariable("id") String id){
        electronsteelyardService.deleteElectronsteelyard(id);
        return "redirect:/Electronsteelyards";
    }

    /*3.添加电子秤设备*/
    @RequestMapping(value = "/AddElectronsteelyard",method = RequestMethod.POST)
    public String addElectronsteelyard(String id, String qrCode, String type, String spec, String station, String cell, String eSName, String eSRange, String eSWeight,
                                       String supplier, String manufacturer, String factoryNumber, String purpose, String buyDate, String person, String organization, String remarks, HttpSession session){
        Electronsteelyard electronsteelyard =new Electronsteelyard();
        electronsteelyard.setId(id);
        electronsteelyard.setType(type);
        electronsteelyard.setSpec(spec);
        electronsteelyard.setStation_id(station);
        electronsteelyard.setCell_id(cell);
        electronsteelyard.seteSName(eSName);
        electronsteelyard.seteSRange(eSRange);
        electronsteelyard.seteSWeight(eSWeight);
        electronsteelyard.setSupplier(supplier);
        electronsteelyard.setManufacturer(manufacturer);
        electronsteelyard.setFactoryNumber(factoryNumber);
        electronsteelyard.setPurpose(purpose);
        electronsteelyard.setBuyDate(buyDate);
        electronsteelyard.setPerson(person);
        electronsteelyard.setOrganization(organization);
        electronsteelyard.setRemarks(remarks);

        if(!qrCode.equals("")){
            electronsteelyard.setQrCode(qrCode);
            electronsteelyard.setUpdate_by(session.getAttribute("id").toString());
            electronsteelyard.setUpdate_date(getcreateTime());
            electronsteelyardService.updateElectronsteelyard(electronsteelyard);;
        }else {
            electronsteelyard.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
            electronsteelyard.setCreate_by(session.getAttribute("id").toString());
            electronsteelyard.setCreate_date(getcreateTime());
            electronsteelyard.setUpdate_by(session.getAttribute("id").toString());
            electronsteelyard.setUpdate_date(getcreateTime());
            electronsteelyard.setDel_flag("0");
            electronsteelyardService.addElectronsteelyard(electronsteelyard);
        }
        return "redirect:/Electronsteelyards";
    }

    /*4.修改电子秤设备信息*/
    @GetMapping("/updateElectronsteelyard/{qrCode}")
    public String updateElectronsteelyard(@PathVariable("qrCode") String qrCode,Model model){
        model.addAttribute("own_qrCode",qrCode);

        Electronsteelyard electronsteelyard=electronsteelyardService.Search_ElectronsteelyardByq(qrCode);
        model.addAttribute("electronsteelyard",electronsteelyard);

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "ElectronsteelyardForm";
    }

    /*5.跳转到添加修改界面*/
    @RequestMapping("/Electronsteelyard_form")
    public String form(Electronsteelyard electronsteelyard,Model model){
        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "ElectronsteelyardForm";
    }

    /*6.根据条件搜索电子秤设备*/
    @RequestMapping(value = "/SearchElectronsteelyard",method = RequestMethod.POST)
    public String Search_Electronsteelyard(String search_type,String search_spec,String search_id,Model model){
        if(search_id.equals("")&&search_type.equals("")&&search_spec.equals("")){
            List<Electronsteelyard> electronsteelyards =electronsteelyardService.getAllElectronsteelyard();
            model.addAttribute("electronsteelyards",electronsteelyards);
            return "ElectronsteelyardList";
        }
        else {
            if (!search_spec.equals("")){
                if (search_id.equals("")){
                    if (search_type.equals("")){
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardBys(search_spec);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                    else {
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardByst(search_spec,search_type);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                }
                else {
                    if (search_type.equals("")){
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardBysi(search_spec,search_id);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                    else {
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardBysit(search_spec,search_id,search_type);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                }
            }
            else {
                if (search_id.equals("")){
                    List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardByt(search_type);
                    model.addAttribute("electronsteelyards",electronsteelyards);
//                    return "ElectronsteelyardList";
                }
                else {
                    if(search_type.equals("")){
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardByi(search_id);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                    else {
                        List<Electronsteelyard> electronsteelyards=electronsteelyardService.Search_ElectronsteelyardByit(search_id,search_type);
                        model.addAttribute("electronsteelyards",electronsteelyards);
//                        return "ElectronsteelyardList";
                    }
                }
            }
        }
        return "ElectronsteelyardList";
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
