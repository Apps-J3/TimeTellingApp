package com.timetelling.gameobjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.timetelling.helper.AssetLoader;

public class Clock {

    private Time time;
    private int hours;
    private int minutes;
    private Sprite clockSprite;
    private Sprite hourHandSprite;
    private Sprite minuteHandSprite;

    public Clock(Time time) {
        this.time = time;
        hours = time.getHours();
        minutes = time.getMinutes();
        clockSprite = new Sprite(AssetLoader.clock);
        hourHandSprite = new Sprite(AssetLoader.hourHand);
        minuteHandSprite = new Sprite(AssetLoader.minuteHand);
    }

    public Clock() {
        this.time = new Time();
        hours = time.getHours();
        minutes = time.getMinutes();
        clockSprite = new Sprite(AssetLoader.clock);
        hourHandSprite = new Sprite(AssetLoader.hourHand);
        minuteHandSprite = new Sprite(AssetLoader.minuteHand);
    }

    public void draw(SpriteBatch batcher, float centerX, float centerY, float size) {
        batcher.draw(clockSprite, centerX-size/2, centerY-size/2, size, size);
        float handWidth = size/60;
        batcher.draw(minuteHandSprite, centerX-handWidth/2, centerY-handWidth/2, handWidth/2, handWidth/2, handWidth, 2*size/5, 1, 1,  (float)displayMinutes());
        batcher.draw(hourHandSprite, centerX-handWidth/2, centerY-handWidth/2, handWidth/2, handWidth/2, handWidth, size/5, 1, 1,  (float)displayHours());
    }

    public double displayHours() {
        return -hours*360/12 - minutes*360/12/60;
    }

    public double displayMinutes(){
        return -minutes*360/60;
    }

    public void setTime(Time time) {
        this.time = time;
        hours = time.getHours();
        minutes = time.getMinutes();
    }

    public Time getTime() {
        return time;
    }
}

