package com.timetelling.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.timetelling.gameworld.GameRenderer;
import com.timetelling.gameworld.GameWorld;

public class InputHandler implements InputProcessor {

    private GameWorld world;
    private GameRenderer renderer;

    public InputHandler(GameWorld world, GameRenderer renderer) {
        this.world = world;
        this.renderer = renderer;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        renderer.touchDown(screenX, Gdx.graphics.getHeight()-screenY);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        renderer.touchUp(screenX, Gdx.graphics.getHeight()-screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        renderer.mouseMoved(screenX, Gdx.graphics.getHeight()-screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}