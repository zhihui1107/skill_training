package com.example.skill_training.service;

import com.example.skill_training.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> select_Type(String type);
    Dictionary select_OneType(String type,String value);
    Dictionary select_OneValue(String type,String label);
    List<Dictionary> otherType(String type,String value);;
}
