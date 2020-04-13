package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {

    public static Skin skin;

    public static void load() {
        skin = new Skin(Gdx.files.internal("uiskin.json"));
    }

    public static void dispose() {

    }
}
