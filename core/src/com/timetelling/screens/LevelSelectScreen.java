package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.gameworld.LevelSelectRenderer;
import com.timetelling.helper.InputHandler;

public class LevelSelectScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public LevelSelectScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("LevelSelectScreen", "Created");
        world = new GameWorld();
        renderer = new LevelSelectRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("LevelSelectScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("LevelSelectScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("LevelSelectScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("LevelSelectScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("LevelSelectScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
