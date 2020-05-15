package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
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
import com.timetelling.screens.WinScreen;

public class ClockDropRenderer extends GameRenderer {

    private ClockDropWorld world;
    private ProgressBar bar;
    private Clock clock;
    private BitmapFont font;
    private ImgButton trashButton;
    private ImgButton turtleButton;
    private Time[] choices;
    private ImgButton displayButton;
    private ImgButton infoMessage;
    private Texture platform;
    private String errorMessage;
    private String instructions;



    public ClockDropRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (ClockDropWorld)world;
        trashButton = new ImgButton(width/5, height/11, width/4, height/5, "", AssetLoader.trash, AssetLoader.font, (width/5)*2,width/16);
        turtleButton = new ImgButton(17*width/30, width/10, width/3, width/3, "", AssetLoader.turtleShadow, AssetLoader.font, (width/5)*2,width/16);
        displayButton = new ImgButton(2*width/5,7*width/18,width/5,width/10, "", AssetLoader.clouds, AssetLoader.font, 0,0);
        //displayButton = new SimpleButton(2*width/5,4*width/9,width/5,width/12,"");
        bar = this.world.getBar();
        errorMessage = "";
        instructions = "If the clock matches the time click the turtle, if not click the trash can";
        platform = AssetLoader.platform;
        font = AssetLoader.font;
        clock = new Clock(this.world.getClockTime());
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        batcher.draw(platform, 11*width/60,height/85, width/4, height/10);
        batcher.draw(platform, 19*width/30,height/85, width/4, height/10);
        font.draw(batcher, errorMessage, 17*width/30, height/15);
        font.draw(batcher, instructions, width/6, 31*height/72);
        drawButtons();
        displayButton.draw(batcher);
        clock.setTime(world.getClockTime());
        clock.draw(batcher, width/2, 2*height/3, width/2);
        bar.draw(batcher, width/5, 9*height/10, 3*width/5, height/20);
        batcher.end();
    }

    private void drawButtons() {
        trashButton.draw(batcher);
        turtleButton.draw(batcher);
        displayButton.setWord(this.world.getTargetTime().toString());
        //displayButton.draw(batcher);
        //infoMessage.draw(batcher);
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) return true;
        else if (trashButton.isClicked(screenX, screenY)) {
            boolean answer = world.pushTrash();
            if (answer) {
                if (bar.isMax()) game.setScreen(new TitleScreen(game));
            } else {
            }
        }
        else if(turtleButton.isClicked(screenX, screenY)) world.pushTurtle();
        return true;
    }
}
