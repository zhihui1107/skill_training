package com.example.skill_training.service;

import com.example.skill_training.entity.Electronsteelyard;

import java.util.List;

public interface ElectronsteelyardService {
    List<Electronsteelyard> getAllElectronsteelyard();

    Electronsteelyard Search_ElectronsteelyardByq(String qrCode);

    List<Electronsteelyard> Search_ElectronsteelyardBysit(String spec,String id,String type);
    List<Electronsteelyard> Search_ElectronsteelyardBys(String spec);
    List<Electronsteelyard> Search_ElectronsteelyardByi(String id);

    List<Electronsteelyard> Search_ElectronsteelyardByt(String type);

    List<Electronsteelyard> Search_ElectronsteelyardBysi(String spec, String id);
    List<Electronsteelyard> Search_ElectronsteelyardByst(String spec,String type);
    List<Electronsteelyard> Search_ElectronsteelyardByit(String id,String type);

    boolean addElectronsteelyard(Electronsteelyard electronsteelyard);
    boolean updateElectronsteelyard(Electronsteelyard electronsteelyard);
    boolean deleteElectronsteelyard(String id);

}
