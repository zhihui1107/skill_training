package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Codeprinter;
import com.example.skill_training.mapper.CodeprinterMapper;
import com.example.skill_training.service.CodeprinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeprinterServiceImpl implements CodeprinterService {
@Autowired
CodeprinterMapper codeprinterMapper;
    @Override
    public List<Codeprinter> getAllCodeprinter() {
        return codeprinterMapper.allCodeprinter();
    }

    @Override
    public Codeprinter Search_CodeprinterByq(String qrCode) {
        return codeprinterMapper.search_CodeprinterByq(qrCode);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterBysit(String spec, String id, String type) {
        return codeprinterMapper.search_CodeprinterBysit(spec, id, type);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterBys(String spec) {
        return codeprinterMapper.search_CodeprinterBys(spec);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterByi(String id) {
        return codeprinterMapper.search_CodeprinterByi(id);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterByt(String type) {
        return codeprinterMapper.search_CodeprinterByt(type);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterBysi(String spec, String id) {
        return codeprinterMapper.search_CodeprinterBysi(spec, id);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterByst(String spec, String type) {
        return codeprinterMapper.search_CodeprinterByst(spec, type);
    }

    @Override
    public List<Codeprinter> Search_CodeprinterByit(String id, String type) {
        return codeprinterMapper.search_CodeprinterByit(id, type);
    }

    @Override
    public boolean addCodeprinter(Codeprinter codeprinter) {
        codeprinterMapper.insertCodeprinter(codeprinter);
        return true;
    }

    @Override
    public boolean updateCodeprinter(Codeprinter codeprinter) {
        codeprinterMapper.updateCodeprinter(codeprinter);
        return true;
    }

    @Override
    public boolean deleteCodeprinter(String id) {
        codeprinterMapper.deleteCodeprinter(id);
        return true;
    }
}
