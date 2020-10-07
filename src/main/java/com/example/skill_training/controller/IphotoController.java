package com.example.skill_training.controller;

import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.entity.Iphoto;
import com.example.skill_training.entity.WorkCell;
import com.example.skill_training.entity.WorkStation;
import com.example.skill_training.service.DictionaryService;
import com.example.skill_training.service.EquipCommonService;
import com.example.skill_training.service.IphotoService;
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
public class IphotoController {
    @Autowired
    private IphotoService iphotoService;
    @Autowired
    private EquipCommonService equipCommonService;
    @Autowired
    private DictionaryService dictionaryService;

    /*1.显示所有安卓PAD设备*/
    @RequestMapping("/Iphotos")
    public String get_All(Model model){
        List<Iphoto> iphotos =iphotoService.getAllIphoto();
        model.addAttribute("iphotos",iphotos);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "IphotoList";
    }

    /*2.删除安卓PAD设备*/
    @GetMapping("/deleteIphoto/{id}")
    public String DeleteIphoto(@PathVariable("id") String id){
        iphotoService.deleteIphoto(id);
        return "redirect:/Iphotos";
    }

    /*3.添加安卓PAD设备*/
    @RequestMapping(value = "/AddIphoto",method = RequestMethod.POST)
    public String addIphoto(String id, String qrCode, String type, String spec, String station, String cell, String iphotoDistance, String iphotoWay, String workEnvironment,
                            String supplier, String manufacturer, String factoryNumber, String purpose, String buyDate, String person, String organization, String remarks, HttpSession session){
        Iphoto iphoto =new Iphoto();
        iphoto.setId(id);
        iphoto.setType(type);
        iphoto.setSpec(spec);
        iphoto.setStation_id(station);
        iphoto.setCell_id(cell);
        iphoto.setIphotoDistance(iphotoDistance);
        iphoto.setIphotoWay(iphotoWay);
        iphoto.setWorkEnvironment(workEnvironment);
        iphoto.setSupplier(supplier);
        iphoto.setManufacturer(manufacturer);
        iphoto.setFactoryNumber(factoryNumber);
        iphoto.setPurpose(purpose);
        iphoto.setBuyDate(buyDate);
        iphoto.setPerson(person);
        iphoto.setOrganization(organization);
        iphoto.setRemarks(remarks);

        if(!qrCode.equals("")){
            iphoto.setQrCode(qrCode);
            iphoto.setUpdate_by(session.getAttribute("id").toString());
            iphoto.setUpdate_date(getcreateTime());
            iphotoService.updateIphoto(iphoto);;
        }else {
            iphoto.setQrCode(getqrTime().replaceAll("[[\\s-:punct:]]", ""));
            iphoto.setCreate_by(session.getAttribute("id").toString());
            iphoto.setCreate_date(getcreateTime());
            iphoto.setUpdate_by(session.getAttribute("id").toString());
            iphoto.setUpdate_date(getcreateTime());
            iphoto.setDel_flag("0");
            iphotoService.addIphoto(iphoto);
        }
        return "redirect:/Iphotos";
    }

    /*4.修改安卓PAD设备信息*/
    @GetMapping("/updateIphoto/{qrCode}")
    public String updateIphoto(@PathVariable("qrCode") String qrCode,Model model){
        model.addAttribute("own_qrCode",qrCode);
        Iphoto iphoto=iphotoService.Search_IphotoByq(qrCode);
        model.addAttribute("iphoto",iphoto);

        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "IphotoForm";
    }

    /*5.跳转到添加修改界面*/
    @RequestMapping("/Iphoto_form")
    public String form(Iphoto iphoto,Model model){
        List<WorkCell> cellNames=equipCommonService.getAllCellName();
        List<WorkStation> stationNames=equipCommonService.getAllStationName();
        model.addAttribute("CellNames",cellNames);
        model.addAttribute("StationNames",stationNames);

        List<Dictionary> Specs=dictionaryService.GetAllSpecBytype();
        List<Dictionary> Types=dictionaryService.GetAllTypeBytype();
        model.addAttribute("Specs",Specs);
        model.addAttribute("Types",Types);
        return "IphotoForm";
    }

    /*6.根据条件搜索安卓PAD设备*/
    @RequestMapping(value = "/SearchIphoto",method = RequestMethod.POST)
    public String Search_Iphoto(String search_type,String search_spec,String search_id,Model model){
        if(search_id.equals("")&&search_type.equals("")&&search_spec.equals("")){
            List<Iphoto> iphotos =iphotoService.getAllIphoto();
            model.addAttribute("iphotos",iphotos);
//            return "IphotoList";
        }
        else {
            if (!search_spec.equals("")){
                if (search_id.equals("")){
                    if (search_type.equals("")){
                        List<Iphoto> iphotos=iphotoService.Search_IphotoBys(search_spec);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                    else {
                        List<Iphoto> iphotos=iphotoService.Search_IphotoByst(search_spec,search_type);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                }
                else {
                    if (search_type.equals("")){
                        List<Iphoto> iphotos=iphotoService.Search_IphotoBysi(search_spec,search_id);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                    else {
                        List<Iphoto> iphotos=iphotoService.Search_IphotoBysit(search_spec,search_id,search_type);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                }
            }
            else {
                if (search_id.equals("")){
                    List<Iphoto> iphotos=iphotoService.Search_IphotoByt(search_type);
                    model.addAttribute("iphotos",iphotos);
//                    return "IphotoList";
                }
                else {
                    if(search_type.equals("")){
                        List<Iphoto> iphotos=iphotoService.Search_IphotoByi(search_id);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                    else {
                        List<Iphoto> iphotos=iphotoService.Search_IphotoByit(search_id,search_type);
                        model.addAttribute("iphotos",iphotos);
//                        return "IphotoList";
                    }
                }
            }
        }
        return "IphotoList";
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
