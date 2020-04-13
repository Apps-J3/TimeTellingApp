package com.timetelling.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.timetelling.game.TimeTellingGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Time Telling App";
		config.width = 720;
		config.height = 960;
		new LwjglApplication(new TimeTellingGame(), config);
		//Pragya was here
	}
}
