package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.MovableClockScreen;

public class ClockDropRenderer extends GameRenderer {

    private SimpleButton trashButton;
    private SimpleButton turtleButton;
    private ClockDropWorld world;
    private ProgressBar bar;
    private Clock clock;
    private BitmapFont font;

    public ClockDropRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (ClockDropWorld)world;
        trashButton = new SimpleButton(width/5, width/4, width/5, width/8, "Trash");
        turtleButton = new SimpleButton(3*width/5, width/4, width/5, width/8, "Turtle");
        bar = this.world.getBar();
        font = AssetLoader.font;
        clock = new Clock(this.world.getClockTime());
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        drawButtons();
        clock.draw(batcher, width/2, 2*height/3, width/2);
        font.draw(batcher, world.getTargetTime().toString(), 3*width/5, width/2);
        batcher.end();
    }

    public void drawButtons() {
        trashButton.draw(batcher);
        turtleButton.draw(batcher);
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (bar.isMax()) game.setScreen(new MovableClockScreen(game));
        super.touchDown(screenX, screenY);
        if (trashButton.isClicked(screenX, screenY)) world.pushTrash();
        else if(turtleButton.isClicked(screenX, screenY)) world.pushTurtle();
        clock.setTime(world.getClockTime());
        return true;
    }
}
