package com.example.skill_training.service;

import com.example.skill_training.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> GetAllSpecBytype();
    List<Dictionary> GetAllTypeBytype();
}
