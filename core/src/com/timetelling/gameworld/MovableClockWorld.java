package com.timetelling.gameworld;

import com.timetelling.gameobjects.Time;
import com.timetelling.helper.TimeGenerator;

public class MovableClockWorld extends GameWorld {

    private Time targetTime;
    private Time clockTime;

    public MovableClockWorld() {
        this.clockTime = TimeGenerator.generateTime();
        this.targetTime = TimeGenerator.generateTime();
    }

    public void submit() {

    }



}
