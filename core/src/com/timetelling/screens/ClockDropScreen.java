package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.ClockDropRenderer;
import com.timetelling.gameworld.ClockDropWorld;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.helper.InputHandler;

public class ClockDropScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public ClockDropScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("ClockDropScreen", "Created");
        world = new ClockDropWorld();
        renderer = new ClockDropRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("ClockDropScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("ClockDropScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("ClockDropScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("ClockDropScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("ClockDropScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
