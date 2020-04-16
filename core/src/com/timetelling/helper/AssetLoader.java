package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;

    public static Texture background;

    public static void load() {

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("background.png");
    }

    public static void dispose() {

    }
}
