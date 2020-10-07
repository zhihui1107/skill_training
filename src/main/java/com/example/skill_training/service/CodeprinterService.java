package com.example.skill_training.service;

import com.example.skill_training.entity.Codeprinter;

import java.util.List;

public interface CodeprinterService{
    List<Codeprinter> getAllCodeprinter();
    Codeprinter Search_CodeprinterByq(String qrCode);

    List<Codeprinter> Search_CodeprinterBysit(String spec,String id,String type);
    List<Codeprinter> Search_CodeprinterBys(String spec);
    List<Codeprinter> Search_CodeprinterByi(String id);

    List<Codeprinter> Search_CodeprinterByt(String type);

    List<Codeprinter> Search_CodeprinterBysi(String spec, String id);
    List<Codeprinter> Search_CodeprinterByst(String spec,String type);
    List<Codeprinter> Search_CodeprinterByit(String id,String type);

    boolean addCodeprinter(Codeprinter codeprinter);
    boolean updateCodeprinter(Codeprinter codeprinter);
    boolean deleteCodeprinter(String id);

}
