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
        expertClock= new Clock(new Time(7,48));
        background = AssetLoader.backgroundSprite;
        title = "Tutorial page";
        titleFont = AssetLoader.bigBlackFont;
        font = AssetLoader.font;
        hourTutorial = "The hour hand, shorter hand, on the clock signifies what hour of the day it is. If the hour hand falls between two numbers the hour is always the number that the hand has just passed. For example, if the hand is between 3 o’clock and 4 o’clock the hour is 3 o’clock.";
        minuteTutorial = "The minute hand, longer hand, on the clock shows the minutes of each hour. It goes around the clock once every 60 minutes. Each tick mark on the clock (there are 60 for 60 minutes in an hour) counts for one minute.";
        easyMessage = "The time shown on the clock is 3:00";
        mediumMessage="The time shown on the clock is 4:10";
        hardMessage= "The time shown on the clock is 6:55";
        expertMessage= "The time shown on the clock is 7:48";
    }

    public void render() {
        super.render();
        batcher.begin();
        titleFont.draw(batcher,title,0,8*height/9,width,Align.center,true);
        font.draw(batcher,hourTutorial,0,7*height/9,width, Align.center,true);
        font.draw(batcher,minuteTutorial,0,6*height/9,width,Align.center,true);
        easyClock.draw(batcher,width/4,height/2,width/5);
        mediumClock.draw(batcher, 3*width/4,height/2,width/5);
        hardClock.draw(batcher, width/4, height/4,width/5);
        expertClock.draw(batcher,3*width/4,height/4,width/5);
        font.draw(batcher,easyMessage,0, 2*height/5, width/2,Align.center,true);
        font.draw(batcher,mediumMessage,1*width/2, 2*height/5,width/2,Align.center,true);
        font.draw(batcher,hardMessage,0, height/8,width/2,Align.center,true);
        font.draw(batcher,expertMessage,1*width/2, height/8,width/2,Align.center,true);
        batcher.end();
    }
}
