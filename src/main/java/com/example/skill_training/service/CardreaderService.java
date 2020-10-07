package com.example.skill_training.service;

import com.example.skill_training.entity.Cardreader;

import java.util.List;

public interface CardreaderService {
    List<Cardreader> getAllCardreader();

    List<Cardreader> Search_CardreaderBysit(String spec,String id,String type);
    Cardreader Search_CardReaderByq(String qrCode);
    List<Cardreader> search_CardreaderBys(String spec);
    List<Cardreader> search_CardreaderByi(String id);
    List<Cardreader> search_CardreaderByt(String type);
    List<Cardreader> search_CardreaderBysi(String spec,String id);
    List<Cardreader> search_CardreaderByst(String spec,String type);
    List<Cardreader> search_CardreaderByit(String id,String type);

    boolean addCardreader(Cardreader Cardreader);
    boolean updateCardreader(Cardreader cardreader);
    boolean deleteCardreader(String id);
}
