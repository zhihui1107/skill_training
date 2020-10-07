package com.example.skill_training.controller;

import com.example.skill_training.entity.*;
import com.example.skill_training.service.CardreaderService;
import com.example.skill_training.service.DictionaryService;
import com.example.skill_training.service.EquipCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Controller
public class CardreaderController {
    @Autowired
    private CardreaderService cardreaderService;
    @Autowired
    private EquipCommonService equipCommonService;
    @Autowired
    private DictionaryService dictionaryService;

    /*1.显示所有读卡器设备*/
    @RequestMapping("/Cardreaders")
    public String get_All(Model model){
        List<Cardreader> Cardreaders =cardreaderService.getAllCardreader();
        model.addAttribute("Cardreaders",Cardreaders);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "CardreaderList";
    }

    /*2.删除读卡器设备*/
    @GetMapping("/deleteCardreader/{id}")
    public String DeletePAD(@PathVariable("id") String id){
        cardreaderService.deleteCardreader(id);
        return "redirect:/Cardreaders";
    }

    /*3.添加读卡器设备*/
    @RequestMapping(value = "/AddCardreader",method = RequestMethod.POST)
    public String addPAD(String id, String qrCode, String type, String spec, String station, String cell, String readerSpeed, String timeInterval, String distance,
                         String readerType, String frequency, String supplier, String manufacturer, String factoryNumber, String purpose, String buyDate, String person, String organization, String remarks, HttpSession session){
        Cardreader cardreader =new Cardreader();
        cardreader.setId(id);
        cardreader.setType(type);
        cardreader.setSpec(spec);
        cardreader.setStation_id(station);
        cardreader.setCell_id(cell);
        cardreader.setReaderSpeed(readerSpeed);
        cardreader.setTimeInterval(timeInterval);
        cardreader.setDistance(distance);
        cardreader.setReaderType(readerType);
        cardreader.setFrequency(frequency);
        cardreader.setSupplier(supplier);
        cardreader.setManufacturer(manufacturer);
        cardreader.setFactoryNumber(factoryNumber);
        cardreader.setPurpose(purpose);
        cardreader.setBuyDate(buyDate);
        cardreader.setPerson(person);
        cardreader.setOrganization(organization);
        cardreader.setRemarks(remarks);

        if(!qrCode.equals("")){
            cardreader.setQrCode(qrCode);
            cardreader.setUpdate_by(session.getAttribute("id").toString());
            cardreader.setUpdate_date(getcreateTime());
            cardreaderService.updateCardreader(cardreader);
        }else {
            cardreader.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
            cardreader.setCreate_by(session.getAttribute("id").toString());
            cardreader.setCreate_date(getcreateTime());
            cardreader.setUpdate_by(session.getAttribute("id").toString());
            cardreader.setUpdate_date(getcreateTime());
            cardreader.setDel_flag("0");
            cardreaderService.addCardreader(cardreader);
        }
        return "redirect:/Cardreaders";
    }

    /*4.修改读卡器设备信息*/
    @GetMapping("/updateCardreader/{qrCode}")
    public String updateCardreader(@PathVariable("qrCode") String qrCode,Model model){
        model.addAttribute("own_qrCode",qrCode);

        Cardreader cardreader=cardreaderService.Search_CardReaderByq(qrCode);
        model.addAttribute("cardreader",cardreader);

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);

        return "CardreaderForm";
    }

    /*5.跳转到添加修改界面*/
    @RequestMapping("/Cardreader_form")
    public String form(Cardreader cardreader,Model model){
        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "CardreaderForm";
    }

    /*6.根据条件搜索读卡器设备*/
    @RequestMapping(value = "/SearchCardreader",method = RequestMethod.POST)
    public String Search_PAD(String search_type,String search_spec,String search_id,Model model){
        if(search_id.equals("")&&search_type.equals("")&&search_spec.equals("")){
            List<Cardreader> Cardreaders =cardreaderService.getAllCardreader();
            model.addAttribute("Cardreaders",Cardreaders);
            return "CardreaderList";
        }
        else {
            if (!search_spec.equals("")){
                if (search_id.equals("")){
                    if (search_type.equals("")){
                        List<Cardreader> cardreaders=cardreaderService.search_CardreaderBys(search_spec);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                    else {
                        List<Cardreader> cardreaders=cardreaderService.search_CardreaderByst(search_spec,search_type);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                }
                else {
                    if (search_type.equals("")){
                        List<Cardreader> cardreaders=cardreaderService.search_CardreaderBysi(search_spec,search_id);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                    else {
                        List<Cardreader> cardreaders=cardreaderService.Search_CardreaderBysit(search_spec,search_id,search_type);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                }
            }
            else {
                if (search_id.equals("")){
                    List<Cardreader> cardreaders=cardreaderService.search_CardreaderByt(search_type);
                    model.addAttribute("Cardreaders",cardreaders);
//                    return "CardreaderList";
                }
                else {
                    if(search_type.equals("")){
                        List<Cardreader> cardreaders=cardreaderService.search_CardreaderByi(search_id);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                    else {
                        List<Cardreader> cardreaders=cardreaderService.search_CardreaderByit(search_id,search_type);
                        model.addAttribute("Cardreaders",cardreaders);
//                        return "CardreaderList";
                    }
                }
            }
        }
        return "CardreaderList";
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
