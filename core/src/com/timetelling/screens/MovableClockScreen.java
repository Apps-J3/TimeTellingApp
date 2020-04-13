package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.gameworld.MovableClockRenderer;
import com.timetelling.gameworld.MovableClockWorld;
import com.timetelling.helper.InputHandler;

public class MovableClockScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public MovableClockScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("MovableClockScreen", "Created");
        world = new MovableClockWorld();
        renderer = new MovableClockRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("MovableClockScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("MovableClockScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("MovableClockScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("MovableClockScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("MovableClockScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
