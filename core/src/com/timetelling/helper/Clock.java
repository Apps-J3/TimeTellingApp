package com.timetelling.helper;

public class Clock {

    private Time time;
    double hours;
    double minutes;

    public Clock(Time time) {
        this.time = time;
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

}

