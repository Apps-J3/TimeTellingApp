package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.LevelSelectScreen;
import com.timetelling.screens.PracticeScreen;
import com.timetelling.screens.TutorialScreen;

public class TitleRenderer extends GameRenderer {

    private SimpleButton levelsScreenButton;
    private SimpleButton tutorialScreenButton;
    private SimpleButton practiceScreenButton;
    private ImgButton turtle;
    private ImgButton clock;

    public TitleRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        levelsScreenButton = new SimpleButton(width/4, height/8, width/2, height/4, "Play");
        tutorialScreenButton = new SimpleButton(width/4, height*3/8, width/4, height/8, "Tutorial");
        practiceScreenButton = new SimpleButton(width/2, height*3/8, width/4, height/8, "Practice");
        clock = new ImgButton(width/5,2*width/3,3*width/5,3*width/6,"", AssetLoader.titleClock, AssetLoader.font, 0,0);
        turtle = new ImgButton(width/5, 2*width/3,width/4,width/3,"",AssetLoader.turtle,AssetLoader.font,0, 0);
    }

    @Override
    public void render() {
        super.render();
        batcher.begin();
        levelsScreenButton.draw(batcher);
        tutorialScreenButton.draw(batcher);
        practiceScreenButton.draw(batcher);
        clock.draw(batcher);
        turtle.draw(batcher);
        batcher.end();
    }

    @Override
    public boolean touchDown(int screenX, int screenY) {
        super.touchDown(screenX, screenY);
        if (levelsScreenButton.isClicked(screenX, screenY)) game.setScreen(new LevelSelectScreen(game));
        else if (tutorialScreenButton.isClicked(screenX, screenY)) game.setScreen(new TutorialScreen(game));
        else if (practiceScreenButton.isClicked(screenX, screenY)) game.setScreen(new PracticeScreen(game));
        return true;
    }
}
