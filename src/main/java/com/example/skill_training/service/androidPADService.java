package com.example.skill_training.service;

import com.example.skill_training.entity.androidPAD;

import java.util.List;

public interface androidPADService {
    List<androidPAD> getAllandroidPAD();
    androidPAD Search_PADByq(String qrCode);

    List<androidPAD> Search_PADBysit(String spec,String id,String type);
    List<androidPAD> Search_PADBys(String spec);
    List<androidPAD> Search_PADByi(String id);

    List<androidPAD> Search_PADByt(String type);

    List<androidPAD> Search_PADBysi(String spec, String id);
    List<androidPAD> Search_PADByst(String spec,String type);
    List<androidPAD> Search_PADByit(String id,String type);

    boolean addandroidPAD(androidPAD androidPAD);
    boolean updateandroidPAD(androidPAD androidPAD);
    boolean deleteandroidPAD(String id);

}
