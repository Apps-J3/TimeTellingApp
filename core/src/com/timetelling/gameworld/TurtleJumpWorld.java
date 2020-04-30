package com.timetelling.gameworld;

import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.TimeGenerator;

public class TurtleJumpWorld extends GameWorld {

    private Clock clock;
    private Time[] choices;
    private ProgressBar bar;

    public TurtleJumpWorld() {
        bar = new ProgressBar();
        clock = new Clock();
        choices = new Time[3];
        setTimes();
    }

    public void setTimes() {
        Time correctTime = TimeGenerator.generateTime();
        clock.setTime(correctTime);
        for (int i = 0; i < choices.length; i++) {
            choices[i] = TimeGenerator.generateTime();
        }
        int rand = (int)(Math.random()*choices.length);
        choices[rand] = correctTime;
    }

    public boolean guess(Time time) {
        if (time.equals(clock.getTime())) {
            setTimes();
            bar.increment(1);
            return true;
        }
        return false;
    }

    public ProgressBar getBar() {
        return bar;
    }

    public Time[] getChoices() {
        return choices;
    }
}
