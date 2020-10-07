package com.example.skill_training.service;

import com.example.skill_training.entity.Iphoto;

import java.util.List;

public interface IphotoService {
    List<Iphoto> getAllIphoto();

    Iphoto Search_IphotoByq(String qrCode);
    List<Iphoto> Search_IphotoBysit(String spec,String id,String type);
    List<Iphoto> Search_IphotoBys(String spec);
    List<Iphoto> Search_IphotoByi(String id);

    List<Iphoto> Search_IphotoByt(String type);

    List<Iphoto> Search_IphotoBysi(String spec, String id);
    List<Iphoto> Search_IphotoByst(String spec,String type);
    List<Iphoto> Search_IphotoByit(String id,String type);

    boolean addIphoto(Iphoto iphoto);
    boolean updateIphoto(Iphoto iphoto);
    boolean deleteIphoto(String id);

}
