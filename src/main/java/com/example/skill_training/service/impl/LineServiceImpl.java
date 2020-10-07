package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Line;
import com.example.skill_training.mapper.LineMapper;
import com.example.skill_training.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {
    @Autowired
    LineMapper lineMapper;
    @Override
    public List<Line> all_Line() {
        return lineMapper.allLine();
    }

    @Override
    public Line one_Line(String lineName) {
        return lineMapper.oneLine(lineName);
    }

    @Override
    public Line select_ById(String id) {
        return lineMapper.selectById(id);
    }

    @Override
    public List<Line> other_Line(String id) {
        return lineMapper.otherLine(id);
    }

    @Override
    public Line oneLineName(String lineNumber) {
        return lineMapper.oneLineName(lineNumber);
    }

    @Override
    public boolean insert_Line(Line line) {
        return lineMapper.insertLine(line);
    }

    @Override
    public boolean delete_Line(Line line) {
        return lineMapper.deleteLine(line);
    }

    @Override
    public boolean update_Line(Line line) {
        return lineMapper.updateLine(line);
    }
}
