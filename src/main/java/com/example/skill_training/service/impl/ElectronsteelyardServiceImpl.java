package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Electronsteelyard;
import com.example.skill_training.mapper.ElectronsteelyardMapper;
import com.example.skill_training.service.ElectronsteelyardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronsteelyardServiceImpl implements ElectronsteelyardService {
@Autowired
    ElectronsteelyardMapper electronsteelyardMapper;
    @Override
    public List<Electronsteelyard> getAllElectronsteelyard() {
        return electronsteelyardMapper.allElectronsteelyard();
    }

    @Override
    public Electronsteelyard Search_ElectronsteelyardByq(String qrCode) {
        return electronsteelyardMapper.search_ElectronsteelyardByq(qrCode);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardBysit(String spec, String id, String type) {
        return electronsteelyardMapper.search_ElectronsteelyardBysit(spec, id, type);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardBys(String spec) {
        return electronsteelyardMapper.search_ElectronsteelyardBys(spec);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardByi(String id) {
        return electronsteelyardMapper.search_ElectronsteelyardByi(id);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardByt(String type) {
        return electronsteelyardMapper.search_ElectronsteelyardByt(type);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardBysi(String spec, String id) {
        return electronsteelyardMapper.search_ElectronsteelyardBysi(spec, id);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardByst(String spec, String type) {
        return electronsteelyardMapper.search_ElectronsteelyardByst(spec, type);
    }

    @Override
    public List<Electronsteelyard> Search_ElectronsteelyardByit(String id, String type) {
        return electronsteelyardMapper.search_ElectronsteelyardByit(id, type);
    }

    @Override
    public boolean addElectronsteelyard(Electronsteelyard electronsteelyard) {
        electronsteelyardMapper.insertElectronsteelyard(electronsteelyard);
        return true;
    }

    @Override
    public boolean updateElectronsteelyard(Electronsteelyard electronsteelyard) {
        electronsteelyardMapper.updateElectronsteelyard(electronsteelyard);
        return true;
    }

    @Override
    public boolean deleteElectronsteelyard(String id) {
        electronsteelyardMapper.deleteElectronsteelyard(id);
        return true;
    }
}
