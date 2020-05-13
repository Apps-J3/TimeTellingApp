package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.MovableClock;

public class PracticeRenderer extends GameRenderer {

    private MovableClock clock;
    private Texture cloud;
    private BitmapFont font;

    public PracticeRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        //clock = new MovableClock()
    }

}
