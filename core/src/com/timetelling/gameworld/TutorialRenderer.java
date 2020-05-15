package com.timetelling.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.ImgButton;
import com.timetelling.helper.AssetLoader;

public class TutorialRenderer extends GameRenderer {

    public TutorialRenderer(GameWorld world, TimeTellingGame game) {
        super(world, game);
       }

    public void render() {
        super.render();
        batcher.begin();
        batcher.end();
    }
}
