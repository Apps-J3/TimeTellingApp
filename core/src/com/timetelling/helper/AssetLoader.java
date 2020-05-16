package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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
    public static BitmapFont whiteFont;
    public static BitmapFont bigBlackFont;
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
    public static Texture turtleShadow;
    public static Texture blackLine;
    public static Texture bubble;
    public static Texture confetti;

    public static void load() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture(Gdx.files.internal("background.png"));
        backgroundSprite = new Sprite(background, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        clock = new Texture(Gdx.files.internal("whiteClock.png"));
        minuteHand = new Texture(Gdx.files.internal("blue.png"));
        hourHand = new Texture(Gdx.files.internal("red.png"));
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
        font.setColor(Color.BLACK);
        font.getData().setScale(Gdx.graphics.getHeight()/64/font.getCapHeight());
        whiteFont = new BitmapFont(Gdx.files.internal("default.fnt"));
        whiteFont.getData().setScale(Gdx.graphics.getHeight()/64/whiteFont.getCapHeight());
        platform = new Texture(Gdx.files.internal("jumpPlatform.png"));
        trash = new Texture(Gdx.files.internal("trash.png"));
        turtle = new Texture(Gdx.files.internal("turtle.png"));
        turtleShadow = new Texture(Gdx.files.internal("turtleShadow.png"));
        turtleSprite = new Sprite(turtle, Gdx.graphics.getWidth()/6, Gdx.graphics.getHeight()/5);
        white = new Texture(Gdx.files.internal("white.png"));
        green = new Texture(Gdx.files.internal("green.png"));
        titleClock = new Texture(Gdx.files.internal("titleClock.png"));
        clouds = new Texture(Gdx.files.internal("clouds.png"));
        turtleJumpBackground = new Texture(Gdx.files.internal("mountaintop.png"));
        turtleJumpBackgroundSprite = new Sprite(turtleJumpBackground,Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/2);
        blackLine = new Texture(Gdx.files.internal("blackRectangle.png"));
        bubble= new Texture(Gdx.files.internal("bubble.png"));
        confetti = new Texture(Gdx.files.internal("confetti.png"));
        bigBlackFont = new BitmapFont(Gdx.files.internal("default.fnt"));
        bigBlackFont.setColor(Color.BLACK);
        bigBlackFont.getData().setScale(2*Gdx.graphics.getHeight()/64/bigBlackFont.getCapHeight());
    }

    public static void dispose() {

    }
}
