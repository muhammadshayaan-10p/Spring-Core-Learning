package com.shayaan.springdemo;

public class BaseballCoach implements Coach {

    //define a private fielf for the dependency
    private FortuneService fortuneService;

    //define a constructor foe dependency injection

    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Run 20 miles";
    }

    @Override
    public String getDailyFortune() {

        // use my fortune service to get the fortune

        return fortuneService.getFortune();
    }
}
