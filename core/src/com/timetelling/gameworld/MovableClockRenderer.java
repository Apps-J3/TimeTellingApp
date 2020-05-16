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
import com.timetelling.screens.WinScreen;

public class MovableClockRenderer extends GameRenderer{

    private MovableClock clock;
    private BitmapFont font;
    private MovableClockWorld world;
    private ImgButton submitButton;
    private Texture turtle;
    private String message;
    private String errorMessage;
    private ProgressBar bar;
    private Texture platform;
    private ImgButton turtleMove;
    private ImgButton platformMove;
    private int score;
    private ImgButton finishLine;
    private ImgButton startLine;

    public MovableClockRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        clock = new MovableClock(width/2, 2*height/3, width/2);
        font = AssetLoader.font;
        finishLine = new ImgButton(0, 4*height/5, width/4,height/25, "FINISH", AssetLoader.blackLine, AssetLoader.whiteFont);
        startLine = new ImgButton(0, 0, width/4, height/25, "START", AssetLoader.blackLine, AssetLoader.whiteFont);
        score = 0;
        platform = AssetLoader.platform;
        turtleMove = new ImgButton(0, height/8, 5*width/20, height/4, "", AssetLoader.turtleShadow, AssetLoader.font);
        platformMove = new ImgButton(0, height/50, width/4,width/6, "", AssetLoader.platform, AssetLoader.font);
        submitButton = new ImgButton(width/2, height/5, width/3, height/6, "Submit Time", AssetLoader.clouds, AssetLoader.font);
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
        platformMove.draw(batcher);
        turtleMove.draw(batcher);
        finishLine.draw(batcher);
        startLine.draw(batcher);
        submitButton.draw(batcher);
        font.draw(batcher, message, 5*width/12, 5*height/12);
        font.draw(batcher, errorMessage, width/2, height/6);
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
                if (bar.isMax()) game.setScreen(new WinScreen(game));
                message = "Set the clock to " + this.world.getTargetTime().toString();
                errorMessage = "Nice Job!";
                score += 1;
                turtleMove = new ImgButton(0, height / 8 + height * score / 20, 5 * width / 20, height / 4, "", AssetLoader.turtleShadow, AssetLoader.font, 0, 0);
                platformMove = new ImgButton(0, height / 50 + height * score / 20, width / 4, width / 6, "", AssetLoader.platform, AssetLoader.font, 0, 0);
            }
            else {
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
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY) {
        if (clock.isPressed()) return clock.touchUp(screenX, screenY);
        return false;
    }
}
