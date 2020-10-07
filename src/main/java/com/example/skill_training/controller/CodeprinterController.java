package com.example.skill_training.controller;

import com.example.skill_training.entity.Codeprinter;
import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.service.CodeprinterService;
import com.example.skill_training.service.DictionaryService;
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
public class CodeprinterController {
@Autowired
    private CodeprinterService codeprinterService;
    @Autowired
    private EquipCommonService equipCommonService;
    @Autowired
    private DictionaryService dictionaryService;

    /*1.显示所有条码打印机设备*/
    @RequestMapping("/Codeprinters")
    public String get_All(Model model){
        List<Codeprinter> codeprinters =codeprinterService.getAllCodeprinter();
        model.addAttribute("codeprinters",codeprinters);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "CodeprinterList";
    }

    /*2.删除条码打印机设备*/
    @GetMapping("/deleteCodeprinter/{id}")
    public String DeleteCodeprinter(@PathVariable("id") String id){
        codeprinterService.deleteCodeprinter(id);
        return "redirect:/Codeprinters";
    }

    /*3.添加条码打印机设备*/
    @RequestMapping(value = "/AddCodeprinter",method = RequestMethod.POST)
    public String addCodeprinter(String id, String qrCode, String type, String spec, String station, String cell, String cPNumber, String mode, String resolution,
                                 String supplier, String manufacturer, String factoryNumber, String purpose, String buyDate, String person, String organization, String remarks, HttpSession session){
        Codeprinter codeprinter =new Codeprinter();
        codeprinter.setId(id);
        codeprinter.setType(type);
        codeprinter.setSpec(spec);
        codeprinter.setStation_id(station);
        codeprinter.setCell_id(cell);
        codeprinter.setcPNumber(cPNumber);
        codeprinter.setMode(mode);
        codeprinter.setResolution(resolution);
        codeprinter.setSupplier(supplier);
        codeprinter.setManufacturer(manufacturer);
        codeprinter.setFactoryNumber(factoryNumber);
        codeprinter.setPurpose(purpose);
        codeprinter.setBuyDate(buyDate);
        codeprinter.setPerson(person);
        codeprinter.setOrganization(organization);
        codeprinter.setRemarks(remarks);

        if(!qrCode.equals("")){
            codeprinter.setQrCode(qrCode);
            codeprinter.setUpdate_by(session.getAttribute("id").toString());
            codeprinter.setUpdate_date(getcreateTime());
            codeprinterService.updateCodeprinter(codeprinter);;
        }else {
            codeprinter.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
            codeprinter.setCreate_by(session.getAttribute("id").toString());
            codeprinter.setCreate_date(getcreateTime());
            codeprinter.setUpdate_by(session.getAttribute("id").toString());
            codeprinter.setUpdate_date(getcreateTime());
            codeprinter.setDel_flag("0");
            codeprinterService.addCodeprinter(codeprinter);
        }
        return "redirect:/Codeprinters";
    }

    /*4.修改条码打印机设备信息*/
    @GetMapping("/updateCodeprinter/{qrCode}")
    public String updateCodeprinter(@PathVariable("qrCode") String qrCode,Model model){
        model.addAttribute("own_qrCode",qrCode);

        Codeprinter codeprinter=codeprinterService.Search_CodeprinterByq(qrCode);
        model.addAttribute("Codeprinter",codeprinter);

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "CodeprinterForm";
    }

    /*5.跳转到添加修改界面*/
    @RequestMapping("/Codeprinter_form")
    public String form(Codeprinter codeprinter,Model model){

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "CodeprinterForm";
    }

    /*6.根据条件搜索条码打印机设备*/
    @RequestMapping(value = "/SearchCodeprinter",method = RequestMethod.POST)
    public String Search_Codeprinter(String search_type,String search_spec,String search_id,Model model){
        if(search_id.equals("")&&search_type.equals("")&&search_spec.equals("")){
            List<Codeprinter> codeprinters =codeprinterService.getAllCodeprinter();
            model.addAttribute("codeprinters",codeprinters);
            return "CodeprinterList";
        }
        else {
            if (!search_spec.equals("")){
                if (search_id.equals("")){
                    if (search_type.equals("")){
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterBys(search_spec);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                    else {
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterByst(search_spec,search_type);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                }
                else {
                    if (search_type.equals("")){
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterBysi(search_spec,search_id);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                    else {
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterBysit(search_spec,search_id,search_type);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                }
            }
            else {
                if (search_id.equals("")){
                    List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterByt(search_type);
                    model.addAttribute("codeprinters",codeprinters);
//                    return "CodeprinterList";
                }
                else {
                    if(search_type.equals("")){
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterByi(search_id);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                    else {
                        List<Codeprinter> codeprinters=codeprinterService.Search_CodeprinterByit(search_id,search_type);
                        model.addAttribute("codeprinters",codeprinters);
//                        return "CodeprinterList";
                    }
                }
            }
        }
        return "CodeprinterList";
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
