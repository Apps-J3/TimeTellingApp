package com.timetelling.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.timetelling.game.TimeTellingGame;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;
import com.timetelling.gameworld.TurtleJumpRenderer;
import com.timetelling.gameworld.TurtleJumpWorld;
import com.timetelling.gameworld.TutorialWorld;
import com.timetelling.helper.InputHandler;

public class TurtleJumpScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private TimeTellingGame game;

    public TurtleJumpScreen(TimeTellingGame game) {
        this.game = game;
        Gdx.app.log("TurtleJumpScreen", "Created");
        world = new TurtleJumpWorld();
        renderer = new TurtleJumpRenderer(world, game);
        Gdx.input.setInputProcessor(new InputHandler(world, renderer));
    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void show() {
        Gdx.app.log("TurtleJumpScreen", "Show called");
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("TurtleJumpScreen", "Resize called");
    }

    @Override
    public void pause() {
        Gdx.app.log("TurtleJumpScreen", "Pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("TurtleJumpScreen", "Resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("TurtleJumpScreen", "Hide called");
    }

    @Override
    public void dispose() {

    }
}
