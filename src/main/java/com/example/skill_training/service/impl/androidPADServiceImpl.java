package com.example.skill_training.service.impl;

import com.example.skill_training.entity.User;
import com.example.skill_training.entity.androidPAD;
import com.example.skill_training.mapper.UserMapper;
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
    public boolean updateandroidPAD(String qrCode) {
        padMapper.updatePAD(qrCode);
        return true;
    }


    @Override
    public boolean deleteandroidPAD(String id) {
        padMapper.deletePAD(id);
        return true;
    }

    @Override
    public List<androidPAD> getAll() {
        return padMapper.allPAD();
    }

    @Override
    public androidPAD Search_PAD(String spec,String id,String type) {
        return padMapper.search_PAD(spec, id, type);
    }

}
