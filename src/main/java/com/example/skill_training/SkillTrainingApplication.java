package com.example.skill_training;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.skill_training.mapper")
public class SkillTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkillTrainingApplication.class, args);
    }

}
