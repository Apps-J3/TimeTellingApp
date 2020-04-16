package com.timetelling.gameobjects;

public class Clock {

    private Time time;
    private int hours;
    private int minutes;

    public Clock(Time time) {
        this.time = time;
        hours = time.getHours();
        minutes = time.getMinutes();
    }

    public Clock() {
        this.time = new Time();
        hours = time.getHours();
        minutes = time.getMinutes();
    }

    public double displayHours() {
        double positionh = 0;
        positionh = (( hours - 3) * (360 / 12)) + (0.5 * minutes);
        return positionh;
    }

    public double displayMinutes(){
        double positionm = 0;
        positionm =( minutes * (360/60) ) -15;
        return positionm;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getTime() {
        return time;
    }
}

