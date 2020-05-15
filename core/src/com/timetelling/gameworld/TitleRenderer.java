package com.timetelling.gameworld;

import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.LevelSelectScreen;
import com.timetelling.screens.PracticeScreen;
import com.timetelling.screens.TutorialScreen;

public class TitleRenderer extends GameRenderer {

    private ImgButton levelsScreenButton;
    private ImgButton tutorialScreenButton;
    private ImgButton practiceScreenButton;
    private ImgButton turtle;
    private ImgButton clock;

    public TitleRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
        levelsScreenButton = new ImgButton(width/4, height/8, width/2, height/4, "Play", AssetLoader.clouds,AssetLoader.font,0,0);
        tutorialScreenButton = new ImgButton(width/4, height*3/8, width/4, height/8, "Tutorial", AssetLoader.clouds,AssetLoader.font,0,0);
        practiceScreenButton = new ImgButton(width/2, height*3/8, width/4, height/8, "Practice", AssetLoader.clouds,AssetLoader.font,0,0);
        clock = new ImgButton(width/5,height/2,3*width/5,2*height/5,"", AssetLoader.titleClock, AssetLoader.font, 0,0);
        turtle = new ImgButton(width/5, height/2,width/4,height/3,"",AssetLoader.turtle,AssetLoader.font,0, 0);
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
