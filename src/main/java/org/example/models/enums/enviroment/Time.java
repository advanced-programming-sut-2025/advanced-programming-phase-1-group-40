package org.example.models.enums.enviroment;

import java.time.LocalTime;


public class Time {





    private int year;
    private Season season;
    private Month month;
    private Weekday weekday;
    private int date;
    private int hour;
    private int daysPassed;
    private LocalTime currentTime = LocalTime.of(hour,0);


    public Time(){

        year = 2025;
        hour = 9;
        daysPassed = 0;
        date = 1;
        season = Season.SPRING;
        month = Month.JANUARY;
        weekday = Weekday.MONDAY;

    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public LocalTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }


}
