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
    private Texture turtle;
    private ImgButton speechBubble;

    public PracticeRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        clock = new MovableClock(width/2, 9*height/16, width/2);
        cloud = AssetLoader.clouds;
        font = AssetLoader.font;
        turtle = AssetLoader.turtle;
        speechBubble = new ImgButton(width/5, height/5,width/4,height/6,"Move the hands of the clock to a time you wish to learn!", AssetLoader.bubble, AssetLoader.font,width/90,height/29);
        speechBubble.setWrapPercentage(.25f);
        button = new ImgButton(width/3, 4*height/5, width/3, height/8, "", AssetLoader.clouds, AssetLoader.font);
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        clock.draw(batcher);
        button.setWord(clock.getTime().toString());
        button.draw(batcher);
        batcher.draw(turtle,0,0 ,width/4,height/3);
        speechBubble.draw(batcher);
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
