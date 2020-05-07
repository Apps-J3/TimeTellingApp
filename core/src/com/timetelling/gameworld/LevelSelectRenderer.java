package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.TimeGenerator;
import com.timetelling.screens.GamemodeSelectScreen;
import com.timetelling.screens.TurtleJumpScreen;

public class LevelSelectRenderer extends GameRenderer {

    private SimpleButton easyButton;
    private SimpleButton mediumButton;
    private SimpleButton hardButton;
    private SimpleButton expertButton;

    public LevelSelectRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        easyButton = new SimpleButton(width/4, width/3, width/4, width/6, "Easy");
        mediumButton = new SimpleButton(width/2, width/3, width/4, width/6, "Medium");
        hardButton = new SimpleButton(width/4, width/6, width/4, width/6, "Hard");
        expertButton = new SimpleButton(width/2, width/6, width/4, width/6, "Expert");
    }

    public void render() {
        super.render();
        batcher.begin();
        easyButton.draw(batcher);
        mediumButton.draw(batcher);
        hardButton.draw(batcher);
        expertButton.draw(batcher);
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
