package com.example.CS440_Application.entity;

public class Schedule {

    private String Team;
    private String Opponent;
    private String Week;


    // Constructors

    public Schedule(String Team, String Opponent, String Week) {
        this.Team = Team;
        this.Opponent = Opponent;
        this.Week = Week;

    }

    // Getters and setters
    public String getTeam() {
        return Team;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public String getOpponent() {
        return Opponent;
    }

    public void setOpponent(String Opponent) {
        this.Opponent = Opponent;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String Week) {
        this.Week = Week;
    }

}

