package com.timetelling.helper;

public class Time  {

    double hours;
    double minutes;

    public Time(int h, int m){
        hours= h;
        minutes= m;
    }

    public double getHours() {
        return hours;
    }

    public double getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }


}