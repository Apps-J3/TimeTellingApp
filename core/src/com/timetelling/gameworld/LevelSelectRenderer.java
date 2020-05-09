package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.helper.TimeGenerator;
import com.timetelling.screens.GamemodeSelectScreen;
import com.timetelling.screens.TurtleJumpScreen;

public class LevelSelectRenderer extends GameRenderer {

    private ImgButton easyButton;
    private ImgButton mediumButton;
    private ImgButton hardButton;
    private ImgButton expertButton;
    private ImgButton clock;
    private ImgButton turtle;

    public LevelSelectRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        easyButton = new ImgButton(width/6, 2*width/5, width/3, width/4, "Easy", AssetLoader.clouds,AssetLoader.font, 100,100);
        mediumButton = new ImgButton(3*width/6, 2*width/5, width/3, width/4, "Medium",AssetLoader.clouds,AssetLoader.font, 100,100);
        hardButton = new ImgButton(width/6, width/7, width/3, width/4, "Hard",AssetLoader.clouds,AssetLoader.font, 100,100);
        expertButton = new ImgButton(3*width/6, width/7, width/3, width/4, "Expert",AssetLoader.clouds,AssetLoader.font, 100,100);
        clock = new ImgButton(width/5,2*width/3,3*width/5,3*width/6,"", AssetLoader.titleClock, AssetLoader.font, 0,0);
    turtle = new ImgButton(width/5, 2*width/3,width/4,width/3,"",AssetLoader.turtle,AssetLoader.font,0, 0);
}

    public void render() {
        super.render();
        batcher.begin();
        easyButton.draw(batcher);
        mediumButton.draw(batcher);
        hardButton.draw(batcher);
        expertButton.draw(batcher);
        clock.draw(batcher);
        turtle.draw(batcher);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        if (super.touchDown(screenX, screenY)) {
            return true;
        }
        if (easyButton.isClicked(screenX, screenY)) {
            TimeGenerator.level = 1;
            game.setScreen(new GamemodeSelectScreen(game));
            return true;
        }
        else if (mediumButton.isClicked(screenX, screenY)) {
            TimeGenerator.level = 2;
            game.setScreen(new GamemodeSelectScreen(game));
            return true;
        }
        else if (hardButton.isClicked(screenX, screenY)) {
            TimeGenerator.level = 3;
            game.setScreen(new GamemodeSelectScreen(game));
            return true;
        }
        else if (expertButton.isClicked(screenX, screenY)) {
            TimeGenerator.level = 4;
            game.setScreen(new GamemodeSelectScreen(game));
            return true;
        }
        return false;
    }
}
