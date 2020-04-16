package com.timetelling.gameobjects;

public class Time  {

    private int hours;
    private int minutes;

    public Time(int h, int m){
        hours= h;
        minutes= m;
    }

    public Time(){
        hours= 12;
        minutes= 0;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean equals(Time time) {
        return time.getHours()==hours && time.getMinutes()==minutes;
    }

    public String toString() {
        if (minutes >= 10) return hours + ":" + minutes;
        else return hours + ":0" + minutes;
    }
}