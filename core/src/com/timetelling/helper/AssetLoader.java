package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;
    private static Texture background;
    public static Sprite backgroundSprite;
    public static Texture clock;
    public static Texture minuteHand;
    public static Texture hourHand;
    public static BitmapFont font;
    public static Texture platform;
    public static Texture trash;
    public static Texture turtle;
    public static Texture green;
    public static Texture white;
    public static Texture turtleJumpBackground;
    public static Sprite turtleJumpBackgroundSprite;
    public static Sprite turtleSprite;
    public static Texture titleClock;
    public static Texture clouds;

    public static void load() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture(Gdx.files.internal("background.png"));
        backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        clock = new Texture(Gdx.files.internal("whiteClock.png"));
        minuteHand = new Texture(Gdx.files.internal("blue.png"));
        hourHand = new Texture(Gdx.files.internal("red.png"));
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        font.setColor(Color.BLACK);
        platform = new Texture(Gdx.files.internal("jumpPlatform.png"));
        trash = new Texture(Gdx.files.internal("trash.png"));
        turtle = new Texture(Gdx.files.internal("turtle.png"));
        white = new Texture(Gdx.files.internal("white.png"));
        green = new Texture(Gdx.files.internal("green.png"));
        titleClock = new Texture(Gdx.files.internal("titleClock.png"));
        clouds = new Texture(Gdx.files.internal("clouds.png"));
        turtleJumpBackground = new Texture(Gdx.files.internal("mountain3.png"));
        turtleJumpBackgroundSprite = new Sprite(turtleJumpBackground,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
    }

    public static void dispose() {

    }
}
