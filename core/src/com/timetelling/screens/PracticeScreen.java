package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.gameworld.PracticeRenderer;
import com.timetelling.gameworld.PracticeWorld;
import com.timetelling.helper.InputHandler;

public class PracticeScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public PracticeScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("PracticeScreen", "Created");
        world = new PracticeWorld();
        renderer = new PracticeRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("PracticeScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("PracticeScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("PracticeScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("PracticeScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("PracticeScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
