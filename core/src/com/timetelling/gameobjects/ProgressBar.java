package com.timetelling.gameobjects;

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
    }

    public void decrement(int dec) {
        score = Math.max(0, score-dec);
    }

}
