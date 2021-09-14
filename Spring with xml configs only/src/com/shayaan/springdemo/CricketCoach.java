package com.shayaan.springdemo;

public class CricketCoach implements Coach{

    //Setter Injection is implemented here
    private FortuneService fortuneService;

    private String email;
    private String teamName;

    //create a no arg contructor

    public CricketCoach() {
    }

    // our setter method to inject dependency, see application config.xml beans for more details
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getDailyWorkout() {
        return "Score 100 runs";
    }


    @Override
    public String getDailyFortune() {
        return "Yayy " + fortuneService.getFortune();
    }
}
