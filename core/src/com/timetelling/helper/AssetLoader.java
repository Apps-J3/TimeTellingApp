package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;

    public static Texture background;

    public static Sprite backgroundSprite;

    public static Texture clock;

    public static Texture minuteHand;

    public static Texture hourHand;

    public static Texture platform;

    public static void load() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("background.png");
        backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        clock = new Texture("whiteClock.png");
        minuteHand = new Texture("blue.png");
        hourHand = new Texture("red.png");
        platform = new Texture("jumpPlatform.png");
    }

    public static void dispose() {

    }
}
