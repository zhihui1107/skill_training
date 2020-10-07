package com.example.skill_training.service.impl;

import com.example.skill_training.entity.Cardreader;
import com.example.skill_training.mapper.CardreaderMapper;
import com.example.skill_training.service.CardreaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardreaderServiceImpl implements CardreaderService {
@Autowired
CardreaderMapper cardreaderMapper;

    @Override
    public List<Cardreader> getAllCardreader() {
        return cardreaderMapper.allCardreader();
    }

    @Override
    public List<Cardreader> Search_CardreaderBysit(String spec, String id, String type) {
        return cardreaderMapper.search_CardreaderBysit(spec, id, type);
    }

    @Override
    public Cardreader Search_CardReaderByq(String qrCode) {

        return cardreaderMapper.search_CardreaderByq(qrCode) ;
    }

    @Override
    public List<Cardreader> search_CardreaderBys(String spec) {
        return cardreaderMapper.search_CardreaderBys(spec);
    }

    @Override
    public List<Cardreader> search_CardreaderByi(String id) {
        return cardreaderMapper.search_CardreaderByi(id);
    }

    @Override
    public List<Cardreader> search_CardreaderByt(String type) {
        return cardreaderMapper.search_CardreaderByt(type);
    }

    @Override
    public List<Cardreader> search_CardreaderBysi(String spec, String id) {
        return cardreaderMapper.search_CardreaderBysi(spec, id);
    }

    @Override
    public List<Cardreader> search_CardreaderByst(String spec, String type) {
        return cardreaderMapper.search_CardreaderByst(spec, type);
    }

    @Override
    public List<Cardreader> search_CardreaderByit(String id, String type) {
        return cardreaderMapper.search_CardreaderByit(id, type);
    }

    @Override
    public boolean addCardreader(Cardreader Cardreader) {
        cardreaderMapper.insertCardreader(Cardreader);
        return true;
    }

    @Override
    public boolean updateCardreader(Cardreader cardreader) {
        cardreaderMapper.updateCardreader(cardreader);
        return true;
    }

    @Override
    public boolean deleteCardreader(String id) {
        cardreaderMapper.deleteCardreader(id);
        return true;
    }
}
