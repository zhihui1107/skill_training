package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Iphoto;
import com.example.skill_training.service.IphotoService;
import com.example.skill_training.entity.androidPAD;
import com.example.skill_training.mapper.IphotoMapper;
import com.example.skill_training.service.androidPADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IphotoServiceImpl implements IphotoService {
@Autowired
    IphotoMapper iphotoMapper;
    @Override
    public List<Iphoto> getAllIphoto() {
        return iphotoMapper.allIphoto();
    }

    @Override
    public Iphoto Search_IphotoByq(String qrCode) {
        return iphotoMapper.search_IphotoByq(qrCode);
    }

    @Override
    public List<Iphoto> Search_IphotoBysit(String spec, String id, String type) {
        return iphotoMapper.search_IphotoBysit(spec, id, type);
    }

    @Override
    public List<Iphoto> Search_IphotoBys(String spec) {
        return iphotoMapper.search_IphotoBys(spec);
    }

    @Override
    public List<Iphoto> Search_IphotoByi(String id) {
        return iphotoMapper.search_IphotoByi(id);
    }

    @Override
    public List<Iphoto> Search_IphotoByt(String type) {
        return iphotoMapper.search_IphotoByt(type);
    }

    @Override
    public List<Iphoto> Search_IphotoBysi(String spec, String id) {
        return iphotoMapper.search_IphotoBysi(spec, id);
    }

    @Override
    public List<Iphoto> Search_IphotoByst(String spec, String type) {
        return iphotoMapper.search_IphotoByst(spec, type);
    }

    @Override
    public List<Iphoto> Search_IphotoByit(String id, String type) {
        return iphotoMapper.search_IphotoByit(id, type);
    }

    @Override
    public boolean addIphoto(Iphoto iphoto) {
        iphotoMapper.insertIphoto(iphoto);
        return true;
    }

    @Override
    public boolean updateIphoto(Iphoto iphoto) {
        iphotoMapper.updateIphoto(iphoto);
        return true;
    }

    @Override
    public boolean deleteIphoto(String id) {
        iphotoMapper.deleteIphoto(id);
        return true;
    }
}
