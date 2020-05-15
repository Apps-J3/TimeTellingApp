package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.MovableClock;
import com.timetelling.helper.AssetLoader;

public class PracticeRenderer extends GameRenderer {

    private MovableClock clock;
    private Texture cloud;
    private BitmapFont font;
    private ImgButton button;

    public PracticeRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        clock = new MovableClock(width/2, height/2, width/2);
        cloud = AssetLoader.clouds;
        font = AssetLoader.font;
        button = new ImgButton(width/3, 3*height/4, width/3, height/8, "", AssetLoader.clouds, AssetLoader.font);
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        clock.draw(batcher);
        button.setWord(clock.getTime().toString());
        button.draw(batcher);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) return true;
        return clock.touchDown(screenX, screenY);

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
