package com.timetelling.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.Clock;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.ProgressBar;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameobjects.Time;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.ClockDropScreen;
import com.timetelling.screens.TitleScreen;
import com.timetelling.screens.WinScreen;

public class TurtleJumpRenderer extends GameRenderer {

    private ProgressBar bar;
    private Time[] choices;
    private ImgButton[] buttons;
    private TurtleJumpWorld world;
    private Skin skin;
    private Clock clock;
    private BitmapFont font;
    private ImgButton message;
    private ImgButton infoMessage;
    private Texture mountain;
    private Texture turtle;
    private ImgButton turtleMove;


    public TurtleJumpRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        this.world = (TurtleJumpWorld)world;
        bar = this.world.getBar();
        choices = this.world.getChoices();
        mountain = AssetLoader.turtleJumpBackground;
        turtle = AssetLoader.turtleShadow;
        turtleMove = new ImgButton(17*width/40,height/10,width/6,height/6,"",AssetLoader.turtleShadow,AssetLoader.font);
        buttons = new ImgButton[choices.length];
        font = AssetLoader.font;
        infoMessage = new ImgButton(0,height/8, width/4,height/7,"Click the corresponding time", AssetLoader.clouds, AssetLoader.font);
        message = new ImgButton(7*width/10,height/8,width/4,height/7,"", AssetLoader.clouds, AssetLoader.font);
        clock = new Clock(this.world.getCorrectTime());
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new ImgButton((i+1)*width/(buttons.length+2), height/4, width/(buttons.length+2), height/12, "", AssetLoader.platform, AssetLoader.whiteFont);
        }
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        batcher.draw(mountain, 0, 0, width, height/2);
        drawButtons();
        clock.draw(batcher, width/2, 2*height/3, width/2);
        infoMessage.draw(batcher);
        message.draw(batcher);
        bar.draw(batcher, width/5, 9*height/10, 3*width/5, height/20);
        turtleMove.draw(batcher);
        batcher.end();
    }


    private void drawButtons() {
        choices = world.getChoices();
        for (int i = 0; i < buttons.length; i++) {
           buttons[i].setWord(choices[i].toString());
           buttons[i].draw(batcher);
        }
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isClicked(screenX, screenY)) {
                boolean answer = world.guess(choices[i]);
                if (answer) {
                    if (bar.isMax()) game.setScreen(new WinScreen(game));
                    infoMessage = new ImgButton(0,height/8, width/4,height/7,"Click the corresponding time", AssetLoader.clouds,AssetLoader.font,0,0);
                    message = new ImgButton(7*width/10,height/8,width/4,height/7,"Great job!",AssetLoader.clouds,AssetLoader.font,0,0);
                    turtleMove = new ImgButton((i+1)*width/(buttons.length+2),17*height/54,width/6,height/6,"", AssetLoader.turtleShadow, AssetLoader.font,0,0);                }
                else {
                    message = new ImgButton(7*width/10,height/8,width/4,height/7,"Oops, the correct time is " + this.world.getCorrectTime().toString(),AssetLoader.clouds,AssetLoader.font,0,0);
                    turtleMove = new ImgButton(17*width/40,height/10,width/6,height/6,"", AssetLoader.turtleShadow, AssetLoader.font, 0,0);
                }
                clock.setTime(world.getCorrectTime());
                return true;
            }
        }
        return super.touchDown(screenX, screenY);
    }
}
