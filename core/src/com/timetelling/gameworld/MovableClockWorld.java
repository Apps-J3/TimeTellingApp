package com.timetelling.gameworld;

import com.timetelling.gameobjects.MovableClock;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.TimeGenerator;

public class MovableClockWorld extends GameWorld {

    private ProgressBar bar;
    private MovableClock clock;
    private Time targetTime;

    public MovableClockWorld() {
        this.targetTime = TimeGenerator.generateTime();
        bar = new ProgressBar(10);
    }

    public void setClock(MovableClock clock) {
        this.clock = clock;
        clock.setTime(TimeGenerator.generateTime());
    }

    public boolean submit() {
        if (targetTime.equals(clock.getTime()) ) {
            bar.increment(1);
            targetTime = TimeGenerator.generateTime();
            clock.setTime(TimeGenerator.generateTime());
            return true;
        }
        return false;
    }

    public Time getTargetTime() {
        return targetTime;
    }

    public ProgressBar getBar() {
        return bar;
    }

}
