package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.awt.Font;

public class AssetLoader {

    public static Skin defaultSkin;

    public static Texture background;

    public static Texture platform;

    public static BitmapFont font;

    public static Skin platformSkin;



    public static void load() {

        defaultSkin = new Skin(Gdx.files.internal("uiskin.json"));
        background = new Texture("background.png");
        platform = new Texture(Gdx.files.internal("platform.png"));
        font = new BitmapFont(Gdx.files.internal("default.fnt"));
       // platformSkin = new Skin(platform, font);

    }

    public static void dispose() {

    }
}
