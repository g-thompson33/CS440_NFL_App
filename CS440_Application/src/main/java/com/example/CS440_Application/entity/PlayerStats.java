package com.example.CS440_Application.entity;

public class PlayerStats {

    private int Player_ID;
    private int Week;
    private int Rushing_Attempts;
    private int Rushing_Yards;
    private int Receptions;
    private int Receiving_Yards;
    private int Passing_Attempts;
    private int Passing_Yards;
    private int Touchdowns;
    private int Interceptions;
    private int Fumbles;

    // Default constructor
    public PlayerStats() {
    }

    // Parameterized constructor
    public PlayerStats(int Player_ID, int Week, int Rushing_Attempts, int Rushing_Yards, int Receptions, int Receiving_Yards,
                       int Passing_Attempts, int Passing_Yards, int Touchdowns, int Interceptions, int Fumbles) {
        this.Player_ID = Player_ID;
        this.Week = Week;
        this.Rushing_Attempts = Rushing_Attempts;
        this.Rushing_Yards = Rushing_Yards;
        this.Receptions = Receptions;
        this.Receiving_Yards = Receiving_Yards;
        this.Passing_Attempts = Passing_Attempts;
        this.Passing_Yards = Passing_Yards;
        this.Touchdowns = Touchdowns;
        this.Interceptions = Interceptions;
        this.Fumbles = Fumbles;
    }

    // Getters and Setters
    public int getPlayerID() {
        return Player_ID;
    }

    public void setPlayer_ID(int Player_ID) {
        this.Player_ID = Player_ID;
    }

    public int getWeek() {
        return Week;
    }

    public void setWeek(int Week) {
        this.Week = Week;
    }

    public int getRushingAttempts() {
        return Rushing_Attempts;
    }

    public void setRushing_Attempts(int Rushing_Attempts) {
        this.Rushing_Attempts = Rushing_Attempts;
    }

    public int getRushingYards() {
        return Rushing_Yards;
    }

    public void setRushing_Yards(int Rushing_Yards) {
        this.Rushing_Yards = Rushing_Yards;
    }

    public int getReceptions() {
        return Receptions;
    }

    public void setReceptions(int Receptions) {
        this.Receptions = Receptions;
    }

    public int getReceivingYards() {
        return Receiving_Yards;
    }

    public void setReceiving_Yards(int Receiving_Yards) {
        this.Receiving_Yards = Receiving_Yards;
    }

    public int getPassingAttempts() {
        return Passing_Attempts;
    }

    public void setPassing_Attempts(int Passing_Attempts) {
        this.Passing_Attempts = Passing_Attempts;
    }

    public int getPassingYards() {
        return Passing_Yards;
    }

    public void setPassing_Yards(int Passing_Yards) {
        this.Passing_Yards = Passing_Yards;
    }

    public int getTouchdowns() {
        return Touchdowns;
    }

    public void setTouchdowns(int Touchdowns) {
        this.Touchdowns = Touchdowns;
    }

    public int getInterceptions() {
        return Interceptions;
    }

    public void setInterceptions(int Interceptions) {
        this.Interceptions = Interceptions;
    }

    public int getFumbles() {
        return Fumbles;
    }

    public void setFumbles(int Fumbles) {
        this.Fumbles = Fumbles;
    }
}
