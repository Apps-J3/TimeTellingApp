package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.helper.AssetLoader;

public class WinRenderer extends GameRenderer {

    private Sprite background;
    private ImgButton turtle;
    private String message;
    private BitmapFont font;
    private ImgButton bubble;

    public WinRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        background = AssetLoader.backgroundSprite;
        font = AssetLoader.font;
        turtle = new ImgButton(0,0 ,width/3,height/2,"", AssetLoader.turtle,AssetLoader.font,0, 0);
        bubble = new ImgButton(width/4, height/3,width/4,height/7,"Great Job!",AssetLoader.bubble,AssetLoader.font,0,0);
        message= "Congartulations you passed the level!";

    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        turtle.draw(batcher);
        bubble.draw(batcher);
        font.draw(batcher, message, width/3, 2*height/3);
        batcher.end();

    }
}
