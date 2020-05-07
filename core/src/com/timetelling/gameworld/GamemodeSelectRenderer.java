package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.screens.ClockDropScreen;
import com.timetelling.screens.MovableClockScreen;
import com.timetelling.screens.TurtleJumpScreen;

public class GamemodeSelectRenderer extends GameRenderer{

    private SimpleButton turtleJumpButton;
    private SimpleButton clockDropButton;
    private SimpleButton movableClockButton;

    public GamemodeSelectRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        turtleJumpButton = new SimpleButton(width/5, width/4, width/5, width/8, "Turtle Jump Game");
        clockDropButton = new SimpleButton(2*width/5, width/4, width/5, width/8, "Clock Drop Game");
        movableClockButton = new SimpleButton(3*width/5, width/4, width/5, width/8, "Movable Clock Game");
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        turtleJumpButton.draw(batcher);
        clockDropButton.draw(batcher);
        movableClockButton.draw(batcher);
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
