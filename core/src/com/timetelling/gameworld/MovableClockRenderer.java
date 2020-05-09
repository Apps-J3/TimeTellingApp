package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.MovableClock;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.TitleScreen;

public class MovableClockRenderer extends GameRenderer{

    private MovableClock clock;
    private BitmapFont font;
    private MovableClockWorld world;
   // private SimpleButton submitButton;
    private ImgButton submitButton;
    private Texture turtle;
    private String message;
    private String errorMessage;
    private ProgressBar bar;
    private Texture platform;

    public MovableClockRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        clock = new MovableClock(width/2, 2*height/3, width/2);
        font = AssetLoader.font;
        platform = AssetLoader.platform;
        //submitButton = new SimpleButton(width/2, height/5, width/3, height/8, "Submit Time");
        submitButton = new ImgButton(width/2, height/5, width/3, height/6, "Submit Time", AssetLoader.clouds, AssetLoader.font,0,0);
        turtle = AssetLoader.turtleShadow;
        this.world = (MovableClockWorld)world;
        this.world.setClock(clock);
        message = "Set the clock to " + this.world.getTargetTime().toString();
        errorMessage = "";
        bar = this.world.getBar();
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        clock.draw(batcher);
        batcher.draw(platform,width/6, height/50, width/4,width/6);
        batcher.draw(turtle, width/7, height/8, 5*width/20, height/4);
        submitButton.draw(batcher);
        font.draw(batcher, message, width/6, 3*height/8);
        font.draw(batcher, errorMessage, width/2, 14*height/40);
        bar.draw(batcher, width/5, 9*height/10, 3*width/5, height/20);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) {
            return true;
        } else if (submitButton.isClicked(screenX, screenY)) {
            boolean answer = world.submit();
            if (answer) {
                if (bar.isMax()) game.setScreen(new TitleScreen(game));
                message = "Set the clock to " + this.world.getTargetTime().toString();
                errorMessage = "Nice Job!";
            } else {
                errorMessage = "Oops! You set the time to " + clock.getTime();
            }
            return true;
        } else if (clock.touchDown(screenX, screenY)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        if (clock.isPressed()) return clock.mouseMoved(screenX, screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY) {
        if (clock.isPressed()) return clock.touchUp(screenX, screenY);
        return false;
    }
}
