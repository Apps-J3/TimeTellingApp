package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.MovableClock;
import com.timetelling.gameobjects.MoveableClock;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;

public class MovableClockRenderer extends GameRenderer{

    private MovableClock clock;
    private BitmapFont font;
    private MovableClockWorld world;
    private SimpleButton submitButton;

    public MovableClockRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        clock = new MovableClock(width/2, height/3, width/2);
        font = AssetLoader.font;
        submitButton = new SimpleButton(width/3, height/4, width/3, height/8, "Submit Time");
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        clock.draw(batcher);
        submitButton.draw(batcher);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) {
            return true;
        } else if (submitButton.isClicked(screenX, screenY)) {
            world.submit();
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return super.mouseMoved(screenX, screenY);
    }

    @Override
    public boolean touchUp(int screenX, int screenY) {
        return super.touchUp(screenX, screenY);
    }
}
