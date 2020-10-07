package com.example.skill_training.service.impl;

import com.example.skill_training.entity.androidPAD;
import com.example.skill_training.mapper.androidPADMapper;
import com.example.skill_training.service.androidPADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class androidPADServiceImpl implements androidPADService {
@Autowired
    androidPADMapper padMapper;

    @Override
    public boolean addandroidPAD(androidPAD androidPAD) {

        padMapper.insertPAD(androidPAD);

        return true;
    }

    @Override
    public boolean updateandroidPAD(androidPAD androidPAD) {
        padMapper.updatePAD(androidPAD);
        return true;
    }


    @Override
    public boolean deleteandroidPAD(String id) {
        padMapper.deletePAD(id);
        return true;
    }

    @Override
    public List<androidPAD> getAllandroidPAD() {
        return padMapper.allPAD();
    }

    @Override
    public androidPAD Search_PADByq(String qrCode) {
        return padMapper.search_PADByq(qrCode);
    }

    @Override
    public List<androidPAD> Search_PADBysit(String spec, String id, String type) {
        return padMapper.search_PADBysit(spec, id, type);
    }

    @Override
    public List<androidPAD> Search_PADBys(String spec) {
        return padMapper.search_PADBys(spec);
    }

    @Override
    public List<androidPAD> Search_PADByi(String id) {

        return padMapper.search_PADByi(id);
    }

    @Override
    public List<androidPAD> Search_PADByt(String type) {
        return padMapper.search_PADByt(type);
    }

    @Override
    public List<androidPAD> Search_PADBysi(String spec, String id) {
        return padMapper.search_PADBysi(spec, id);
    }

    @Override
    public List<androidPAD> Search_PADByst(String spec, String type) {
        return padMapper.search_PADByst(spec, type);
    }

    @Override
    public List<androidPAD> Search_PADByit(String id, String type) {
        return padMapper.search_PADByit(id, type);
    }

}
