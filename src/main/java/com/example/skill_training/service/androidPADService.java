package com.example.skill_training.service;

import com.example.skill_training.entity.androidPAD;

import java.util.List;

public interface androidPADService {
    List<androidPAD> getAll();

    androidPAD Search_PAD(String spec,String id,String type);

    boolean addandroidPAD(androidPAD androidPAD);
    boolean updateandroidPAD(String qrCode);
    boolean deleteandroidPAD(String id);


}
