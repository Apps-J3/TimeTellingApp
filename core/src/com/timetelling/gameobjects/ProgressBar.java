package com.timetelling.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.timetelling.helper.AssetLoader;

public class ProgressBar {

    private int score, maxScore;
    private Texture white;
    private Texture green;
    private int border;

    public ProgressBar(int maxScore) {
        this.maxScore = maxScore;
        setDefaults();
    }

    public ProgressBar() {
        maxScore = 20;
        setDefaults();
    }

    private void setDefaults() {
        score = 0;
        white = AssetLoader.white;
        green = AssetLoader.green;
        border = 5;
    }

    public void increment(int inc) {
        score = Math.min(maxScore, score+inc);
        printScore();
    }

    public void decrement(int dec) {
        score = Math.max(0, score-dec);
        printScore();
    }

    public void draw(SpriteBatch batcher, float x, float y, float width, float height) {
        batcher.draw(white, x, y, width, height);
        batcher.draw(green, x+border, y+border, score*(width-2*border)/maxScore, height-2*border);
    }

    public int getScore() {
        return score;
    }

    public boolean isMax() {
        return score==maxScore;
    }

    private void printScore() {
        Gdx.app.log("ProgressBar", "Score: " + score);
    }

}
