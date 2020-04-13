package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.gameworld.TutorialRenderer;
import com.timetelling.gameworld.TutorialWorld;
import com.timetelling.helper.InputHandler;

public class TutorialScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public TutorialScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("TutorialScreen", "Created");
        world = new TutorialWorld();
        renderer = new TutorialRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("TutorialScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("TutorialScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("TutorialScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("TutorialScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("TutorialScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
