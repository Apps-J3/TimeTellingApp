package com.timetelling.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.TitleScreen;

public class TimeTellingGame extends Game {

	@Override
	public void create () {
		Gdx.app.log("Game", "created");
		AssetLoader.load();
		setScreen(new TitleScreen(this));
	}

	public void dispose() {
	    super.dispose();
    }

}
