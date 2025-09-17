package com.example.crickinfo.ui.transform;

import java.util.Date;

public class Match {
    private String matchName;
    private Date date;
    private String place;
    private int numberOfOvers;
    private int maxOversPerBowler;
    private int wideNoBallExtraRunValue;

    public Match(String matchName, Date date, String place, int numberOfOvers, int maxOversPerBowler, int wideNoBallExtraRunValue) {
        this.matchName = matchName;
        this.date = date;
        this.place = place;
        this.numberOfOvers = numberOfOvers;
        this.maxOversPerBowler = maxOversPerBowler;
        this.wideNoBallExtraRunValue = wideNoBallExtraRunValue;
    }

    // Getters and setters
    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumberOfOvers() {
        return numberOfOvers;
    }

    public void setNumberOfOvers(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
    }

    public int getMaxOversPerBowler() {
        return maxOversPerBowler;
    }

    public void setMaxOversPerBowler(int maxOversPerBowler) {
        this.maxOversPerBowler = maxOversPerBowler;
    }

    public int getWideNoBallExtraRunValue() {
        return wideNoBallExtraRunValue;
    }

    public void setWideNoBallExtraRunValue(int wideNoBallExtraRunValue) {
        this.wideNoBallExtraRunValue = wideNoBallExtraRunValue;
    }
}
