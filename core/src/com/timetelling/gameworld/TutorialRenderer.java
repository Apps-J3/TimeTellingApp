package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Align;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.MovableClock;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.AssetLoader;

public class TutorialRenderer extends GameRenderer {
    private String title;
    private Sprite background;
    private BitmapFont titleFont;
    private String hourTutorial;
    private String minuteTutorial;
    private BitmapFont font;
    private Clock easyClock;
    private Clock mediumClock;
    private Clock hardClock;
    private Clock expertClock;
    private String easyMessage;
    private String mediumMessage;
    private String hardMessage;
    private String expertMessage;


    public TutorialRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        easyClock = new Clock(new Time(3,0) );
        mediumClock= new Clock(new Time(4,15));
        hardClock = new Clock(new Time(6,55));
        expertClock= new Clock(new Time(7,38));
        background = AssetLoader.backgroundSprite;
        title = "Tutorial page";
        titleFont = AssetLoader.bigBlackFont;
        font = AssetLoader.font;
        hourTutorial = "The hour hand, shorter hand, on the clock signifies what hour of the day it is. If the hour hand falls between two numbers the hour is always the number that the hand has just passed. For example, if the hand is between 3 o’clock and 4 o’clock the hour is 3 o’clock.";
        minuteTutorial = "The minute hand, longer hand, on the clock shows the minutes of each hour. It goes around the clock once every 60 minutes. Each tick mark on the clock (there are 60 for 60 minutes in an hour) counts for one minute.";

    }

    public void render() {
        super.render();
        batcher.begin();
        titleFont.draw(batcher,title,0,8*height/9,width/2,Align.center,true);
        font.draw(batcher,hourTutorial,0,7*height/9,width, Align.center,true);
        font.draw(batcher,minuteTutorial,0,6*height/9,width,Align.center,true);
        easyClock.draw(batcher,width/5,height/2,width/5);
        mediumClock.draw(batcher, 4*width/5,height/2,width/5);
        hardClock.draw(batcher, width/5, height/4,width/5);
        expertClock.draw(batcher,4*width/5,height/4,width/5);
        batcher.end();
    }
}
