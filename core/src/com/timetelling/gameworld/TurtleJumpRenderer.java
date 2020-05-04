package com.timetelling.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.ClockDropScreen;

public class TurtleJumpRenderer extends GameRenderer {

    private ProgressBar bar;
    private Time[] choices;
    private ImgButton[] buttons;
    private TurtleJumpWorld world;
    private Skin skin;
    private Clock clock;

    public TurtleJumpRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (TurtleJumpWorld)world;
        bar = this.world.getBar();
        choices = this.world.getChoices();
        buttons = new ImgButton[choices.length];
        clock = new Clock(this.world.getCorrectTime());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new ImgButton((i+1)*width/(buttons.length+2), width/3, width/(buttons.length+2), width/6, "", AssetLoader.platform, AssetLoader.font, 0,0);
        }
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        drawButtons();
        clock.draw(batcher, width/2, 2*height/3, width/2);
        batcher.end();
    }


    public void drawButtons() {
        for (int i = 0; i < buttons.length; i++) {
           buttons[i].setWord(choices[i].toString());
           buttons[i].draw(batcher);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (bar.isMax()) game.setScreen(new ClockDropScreen(game));
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isClicked(screenX, screenY)) {
                world.guess(choices[i]);
                clock.setTime(world.getCorrectTime());
            }
        }
        return super.touchDown(screenX, screenY);
    }
}
