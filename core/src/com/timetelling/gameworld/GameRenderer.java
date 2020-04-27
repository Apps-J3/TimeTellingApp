package com.timetelling.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameobjects.SimpleButton;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.helper.AssetLoader;
import com.timetelling.screens.TitleScreen;

public class GameRenderer {

    private GameWorld world;
    protected OrthographicCamera cam;
    protected ShapeRenderer shapeRenderer;
    protected SpriteBatch batcher;
    protected int width, height;
    protected TimeTellingGame game;
    private SimpleButton backButton;
    private Sprite background;
    private Sprite clock;

    public GameRenderer(GameWorld world, TimeTellingGame game) {
        this.game = game;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, width, height);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        background = AssetLoader.backgroundSprite;
        clock = AssetLoader.clockSprite;
        backButton = new SimpleButton(20, height-20-height/20, width/10, height/20, "Home");
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        batcher.draw(background,0,0);
        backButton.draw(batcher);
        batcher.end();
        batcher.begin();
        batcher.draw(clock, 0 , 0);
        batcher.end();
    }

    public boolean touchDown(int screenX, int screenY) {
        if (backButton.isClicked(screenX, screenY)) game.setScreen(new TitleScreen(game));
        return true;
    }

}
