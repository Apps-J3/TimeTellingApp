package com.timetelling.gameworld;

import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.TimeGenerator;

public class TurtleJumpWorld extends GameWorld {

    private Time correctTime;
    private Time[] choices;
    private ProgressBar bar;

    public TurtleJumpWorld() {
        bar = new ProgressBar();
        correctTime = new Time();
        choices = new Time[3];
        setTimes();
    }

    public void setTimes() {
        correctTime = TimeGenerator.generateTime();
        for (int i = 0; i < choices.length; i++) {
            choices[i] = TimeGenerator.generateTime();
        }
        int rand = (int)(Math.random()*choices.length);
        choices[rand] = correctTime;
    }

    public boolean guess(Time time) {
        if (time.equals(correctTime)) {
            setTimes();
            bar.increment(1);
            return true;
        }
        return false;
    }

    public Time getCorrectTime() {
        return correctTime;
    }

    public ProgressBar getBar() {
        return bar;
    }

    public Time[] getChoices() {
        return choices;
    }
}
