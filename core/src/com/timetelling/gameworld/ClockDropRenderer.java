package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.MovableClockScreen;
import com.timetelling.screens.TitleScreen;

import sun.java2d.pipe.SpanShapeRenderer;

public class ClockDropRenderer extends GameRenderer {

    private ClockDropWorld world;
    private ProgressBar bar;
    private Clock clock;
    private BitmapFont font;
    private ImgButton trashButton;
    private ImgButton turtleButton;
    private Time[] choices;
    private SimpleButton displayButton;
    private ImgButton infoMessage;


    public ClockDropRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (ClockDropWorld)world;
        trashButton = new ImgButton(width/6, width/10, width/3, width/3, "", AssetLoader.trash, AssetLoader.font, (width/5)*2,width/16);
        turtleButton = new ImgButton(3*width/5, width/10, width/3, width/3, "", AssetLoader.turtle, AssetLoader.font, (width/5)*2,width/16);
        displayButton = new SimpleButton(2*width/5,4*width/9,width/5,width/10,"");
        infoMessage = new ImgButton(0,height/2, width/4,height/6,"If the clock matches the time click the turtle, if not click the trash can", AssetLoader.clouds,AssetLoader.font,0,0);
        bar = this.world.getBar();
        font = AssetLoader.font;
        clock = new Clock(this.world.getClockTime());
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        drawButtons();
        clock.setTime(world.getClockTime());
        clock.draw(batcher, width/2, 2*height/3, width/2);
        bar.draw(batcher, width/5, 9*height/10, 3*width/5, height/20);
        batcher.end();
    }

    private void drawButtons() {
        trashButton.draw(batcher);
        turtleButton.draw(batcher);
        displayButton.setWord(this.world.getTargetTime().toString());
        displayButton.draw(batcher);
        infoMessage.draw(batcher);
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) return true;
        else if (trashButton.isClicked(screenX, screenY)) {
            boolean answer = world.pushTrash();
            if (answer) {
                if (bar.isMax()) game.setScreen(new TitleScreen(game));
            } else {
            }
        }
        else if(turtleButton.isClicked(screenX, screenY)) world.pushTurtle();
        return true;
    }
}
