package com.example.CS440_Application.entity;

public class Players {

    private String name;
    private String team;
    private String position;
    private int Player_ID;
    private int Number;

    // Parameterized constructor
    public Players(String name, String team, String postion, int Player_ID, int Number) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.Player_ID = Player_ID;
        this.Number = Number;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
}