package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;

    public static Texture background;

    public static Sprite backgroundSprite;

    public static void load() {

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("background.png");
        backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public static void dispose() {

    }
}
