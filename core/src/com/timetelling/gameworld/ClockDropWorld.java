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

    private void initializeNewClock() {
        targetTime = TimeGenerator.generateTime();
        if (Math.random() < 0.5) clockTime = TimeGenerator.generateTime();
        else clockTime = targetTime;
    }

    public boolean pushTrash() {
        if (!targetTime.equals(clockTime)) {
            bar.increment(1);
            if (Math.random() < 0.5) clockTime = TimeGenerator.generateTime();
            else clockTime = targetTime;
            return true;
        }
        return false;
    }

    public boolean pushTurtle() {
        if (targetTime.equals(clockTime)) {
            bar.increment(1);
            initializeNewClock();
            return true;
        }
        return false;
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
