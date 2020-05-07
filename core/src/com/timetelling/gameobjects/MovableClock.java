package com.timetelling.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MovableClock extends Clock {

    private float centerX, centerY, size;
    private int handPressed;
    private boolean isPressed;
    private Rectangle bounds;

    public MovableClock(float centerX, float centerY, float size, Time time) {
        super(time);
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
        handPressed = 0;
        isPressed = false;
    }

    public MovableClock(float centerX, float centerY, float size) {
        super();
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
        handPressed = 0;
        isPressed = false;
    }

    //finish
    public void touchDown() {

    }

    public void touchUp() {
        handPressed = 0;
        isPressed = false;
    }

    //finish
    public void mouseMoved() {

    }

    public boolean isPressed() {
        return isPressed;
    }

    public void draw(SpriteBatch batcher) {
        super.draw(batcher, centerX, centerY, size);
    }

}
