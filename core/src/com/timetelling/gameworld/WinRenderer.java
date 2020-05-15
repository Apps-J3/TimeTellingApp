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
    private ImgButton confetti;

    public WinRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        background = AssetLoader.backgroundSprite;
        font = AssetLoader.bigBlackFont;
        turtle = new ImgButton(0,0 ,width/3,height/2,"", AssetLoader.turtle,AssetLoader.font,0, 0);
        bubble = new ImgButton(width/4, height/3,width/4,height/7,"Great Job!",AssetLoader.bubble,AssetLoader.font,0,0);
        message= "Congratulations you passed the level!";
        confetti = new ImgButton(0,height/3,width,2*height/3,"",AssetLoader.confetti,AssetLoader.font);
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        turtle.draw(batcher);
        bubble.draw(batcher);
        confetti.draw(batcher);
        font.draw(batcher, message, width/6, 2*height/3);
        batcher.end();

    }
}
