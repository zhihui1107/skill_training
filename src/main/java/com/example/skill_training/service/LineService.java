package com.example.skill_training.service;

import com.example.skill_training.entity.Line;

import java.util.List;

public interface LineService {
    List<Line> all_Line();
    Line one_Line(String lineName);
    Line select_ById(String id);
    List<Line> other_Line(String id);
    Line oneLineName(String lineNumber);
    boolean insert_Line(Line line);
    boolean delete_Line(Line line);
    boolean update_Line(Line line);
}
