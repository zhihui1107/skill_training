package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Dictionary;
import com.example.skill_training.mapper.DictionaryMapper;
import com.example.skill_training.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
@Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> GetAllSpecBytype() {
        return dictionaryMapper.GetAllSpecBytype();
    }

    @Override
    public List<Dictionary> GetAllTypeBytype() {
        return dictionaryMapper.GetAllTypeBytype();
    }
}
