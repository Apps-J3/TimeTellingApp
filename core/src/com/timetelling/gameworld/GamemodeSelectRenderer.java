package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.ClockDropScreen;
import com.timetelling.screens.MovableClockScreen;
import com.timetelling.screens.TurtleJumpScreen;

public class GamemodeSelectRenderer extends GameRenderer{

    private ImgButton turtleJumpButton;
    private ImgButton clockDropButton;
    private ImgButton movableClockButton;
    private ImgButton clock;
    private ImgButton turtle;

    public GamemodeSelectRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        turtleJumpButton = new ImgButton(width/5, width/4, width/5, width/8, "Turtle Jump Game", AssetLoader.clouds, AssetLoader.font, 0,0);
        clockDropButton = new ImgButton(2*width/5, width/4, width/5, width/8, "Clock Drop Game", AssetLoader.clouds, AssetLoader.font, 0,0);
        movableClockButton = new ImgButton(3*width/5, width/4, width/5, width/8, "Movable Clock Game", AssetLoader.clouds, AssetLoader.font, 0,0);
        clock = new ImgButton(width/5,2*width/3,3*width/5,3*width/6,"", AssetLoader.titleClock, AssetLoader.font, 0,0);
        turtle = new ImgButton(width/5, 2*width/3,width/4,width/3,"",AssetLoader.turtle,AssetLoader.font,0, 0);
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        turtleJumpButton.draw(batcher);
        clockDropButton.draw(batcher);
        movableClockButton.draw(batcher);
        clock.draw(batcher);
        turtle.draw(batcher);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) {
            return true;
        }
        if (turtleJumpButton.isClicked(screenX, screenY)) {
            game.setScreen(new TurtleJumpScreen(game));
            return true;
        }
        else if (clockDropButton.isClicked(screenX, screenY)) {
            game.setScreen(new ClockDropScreen(game));
            return true;
        }
        else if (movableClockButton.isClicked(screenX, screenY)) {
            game.setScreen(new MovableClockScreen(game));
            return true;
        }
        return false;
    }


}
