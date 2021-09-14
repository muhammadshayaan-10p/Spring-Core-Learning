package com.shayaan.springdemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DatabaseFortuneService implements FortuneService{

    @Override
    public String getDailyFortune() {
        return null;
    }
}
