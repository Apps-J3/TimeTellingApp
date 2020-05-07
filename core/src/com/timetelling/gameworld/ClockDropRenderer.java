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

public class ClockDropRenderer extends GameRenderer {

    private ClockDropWorld world;
    private ProgressBar bar;
    private Clock clock;
    private BitmapFont font;
    private ImgButton trashButton;
    private ImgButton turtleButton;
    private Time[] choices;

    public ClockDropRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (ClockDropWorld)world;
        trashButton = new ImgButton(width/6, width/4, width/3, width/3, "", AssetLoader.trash, AssetLoader.font, (width/5)*2,width/16);
        turtleButton = new ImgButton(3*width/5, width/4, width/3, width/3, "", AssetLoader.turtle, AssetLoader.font, (width/5)*2,width/16);
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
        batcher.end();
    }

    public void drawButtons() {
        trashButton.draw(batcher);
        turtleButton.draw(batcher);
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (bar.isMax()) {
            game.setScreen(new TitleScreen(game));
            return true;
        }
        if (super.touchDown(screenX, screenY)) {

        };
        if (trashButton.isClicked(screenX, screenY)) world.pushTrash();
        else if(turtleButton.isClicked(screenX, screenY)) world.pushTurtle();
        return true;
    }
}
