package com.timetelling.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.timetelling.helper.TimeGenerator;

public class MovableClock extends Clock {

    private float centerX, centerY, size;
    private int handPressed;
    private boolean isPressed;
    private Rectangle bounds;
    private int error;

    public MovableClock(float centerX, float centerY, float size, Time time) {
        super(time);
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
        setDefaults();
    }

    public MovableClock(float centerX, float centerY, float size) {
        super();
        this.centerX = centerX;
        this.centerY = centerY;
        this.size = size;
        setDefaults();
    }

    private void setDefaults() {
        handPressed = 0;
        isPressed = false;
        error = 20;
    }

    public boolean touchDown(int x, int y) {
        if (getR(x, y) < size/2) {
            float theta = getTheta(x, y);
            if (areTouching((float) displayHours(), theta)) {
                handPressed = 1;
                isPressed = true;
            }
            else if (areTouching((float) displayMinutes(), theta)) {
                handPressed = 2;
                isPressed = true;
            }
            return true;
        }
        return false;
    }

    public boolean touchUp(int screenX, int screenY) {
        float theta = getTheta(screenX, screenY);
        if (handPressed == 1) {
            int hour = (int)((theta + 360)/30)+1;
            hour = 12-hour;
            if (hour==0) hour = 12;
            setTime(new Time(hour, getTime().getMinutes()));
        }
        else if (handPressed == 2) {
            int minute = (int)((theta + 360)/6)+1;
            minute = 60-minute;
            setTime(new Time(getTime().getHours(), minute));
        }
        handPressed = 0;
        isPressed = false;
        return true;
    }

    public boolean mouseMoved(int x, int y) {
        float theta = getTheta(x, y);
        if (handPressed == 1) {
            int hour = (int)((theta + 360)/30)+1;
            hour = 12-hour;
            setTime(new Time(hour, getTime().getMinutes()));
        }
        else if (handPressed == 2) {
            int minute = (int)((theta + 360)/6)+1;
            minute = 60-minute;
            setTime(new Time(getTime().getHours(), minute));
        }
        return true;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void draw(SpriteBatch batcher) {
        super.draw(batcher, centerX, centerY, size);
    }

    private float getR(float x, float y) {
        return (float)Math.sqrt((x-centerX)*(x-centerX)+(y-centerY)*(y-centerY));
    }

    private float getTheta(float x, float y) {
        float angle =  -180*(float)Math.atan((x-centerX)/(y-centerY))/(float)Math.PI;
        if (y < centerY) {
            angle += 180;
        } else if (x > centerX) angle += 360;
        angle -= 360;
        return angle;
    }

    private boolean areTouching(float angle1, float angle2) {
        return Math.abs(angle1-angle2) < error || Math.abs(angle1-angle2) > (360-error);
    }

}
