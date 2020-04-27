package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

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
