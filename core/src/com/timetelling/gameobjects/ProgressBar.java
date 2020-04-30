package com.timetelling.gameobjects;

import com.badlogic.gdx.Gdx;

public class ProgressBar {

    private int score, maxScore;

    public ProgressBar(int maxScore) {
        this.maxScore = maxScore;
        score = 0;
    }

    public ProgressBar() {
        maxScore = 20;
        score = 0;
    }

    public void increment(int inc) {
        score = Math.min(maxScore, score+inc);
        printScore();
    }

    public void decrement(int dec) {
        score = Math.max(0, score-dec);
        printScore();
    }

    public int getScore() {
        return score;
    }

    public boolean isMax() {
        return score==maxScore;
    }

    public void printScore() {
        Gdx.app.log("ProgressBar", "Score: " + score);
    }

}
