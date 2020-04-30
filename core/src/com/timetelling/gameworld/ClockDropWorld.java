package com.timetelling.gameworld;

import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.TimeGenerator;

public class ClockDropWorld extends GameWorld {

    private Time targetTime;
    private Time clockTime;
    private ProgressBar bar;

    public ClockDropWorld() {
        bar = new ProgressBar();
        targetTime = new Time();
        clockTime = new Time();
        initializeNewClock();
    }

    public void initializeNewClock() {
        targetTime = TimeGenerator.generateTime();
        if (Math.random() < 0.5) clockTime = TimeGenerator.generateTime();
        else clockTime = targetTime;
    }

    public void pushTrash() {
        if (!targetTime.equals(clockTime)) {
            bar.increment(1);
            if (Math.random() < 0.5) clockTime = TimeGenerator.generateTime();
            else clockTime = targetTime;
        }
    }

    public void pushTurtle() {
        if (targetTime.equals(clockTime)) {
            bar.increment(1);
            initializeNewClock();
        }
    }

    public Time getTargetTime() {
        return targetTime;
    }

    public Time getClockTime() {
        return clockTime;
    }

    public ProgressBar getBar() {
        return bar;
    }
}
