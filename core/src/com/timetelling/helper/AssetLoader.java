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

    public static Sprite clockSprite;

    public static Sprite minutehand;

    public static Sprite hourhand;

    public static void load() {

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("background.png");
        Sprite backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        clock = new Texture("ClockFace.png");
        clockSprite = new Sprite(clock);

    }

    public static void dispose() {

    }
}
