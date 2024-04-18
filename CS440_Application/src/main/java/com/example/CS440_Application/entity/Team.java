package com.example.CS440_Application.entity;


public class Team {

    private String name;
    private String city;
    private String mascot;
    private String coach;
    private String stadium;
    private String division;
    private String record;

    // Constructors

    public Team(String name, String city, String mascot, String coach, String stadium, String division, String record) {
        this.name = name;
        this.city = city;
        this.mascot = mascot;
        this.coach = coach;
        this.stadium = stadium;
        this.division = division;
        this.record = record;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
