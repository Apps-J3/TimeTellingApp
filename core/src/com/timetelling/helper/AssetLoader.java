package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;
    public static Texture background;
    public static Sprite backgroundSprite;
    public static Texture clock;
    public static Texture minuteHand;
    public static Texture hourHand;
    public static BitmapFont font;
    public static Texture platform;
    public static Texture trash;
    public static Texture turtle;

    public static void load() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture(Gdx.files.internal("background.png"));
        backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        clock = new Texture(Gdx.files.internal("whiteClock.png"));
        minuteHand = new Texture(Gdx.files.internal("blue.png"));
        hourHand = new Texture(Gdx.files.internal("red.png"));
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        platform = new Texture(Gdx.files.internal("jumpPlatform.png"));
        trash = new Texture(Gdx.files.internal("trash.png"));
        turtle = new Texture(Gdx.files.internal("turtle.png"));
    }

    public static void dispose() {

    }
}
