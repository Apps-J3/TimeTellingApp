package com.timetelling.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.timetelling.helper.AssetLoader;

public class SimpleButton {

    private Rectangle bounds;
    private String word;
    private boolean isPressed = false;
    private TextButton textButton;

    public SimpleButton(float x, float y, float width, float height, String word) {
        this.word = word;
        bounds = new Rectangle(x, y, width, height);
        textButton = new TextButton(word, AssetLoader.skin, "default");
        textButton.setWidth(width);
        textButton.setHeight(height);
        textButton.setPosition(x, y);
    }

    public SimpleButton(float x, float y, float width, float height) {
        this.word = "";
        bounds = new Rectangle(x, y, width, height);
        textButton = new TextButton(word, AssetLoader.skin, "default");
        textButton.setWidth(width);
        textButton.setHeight(height);
        textButton.setPosition(x, y);
    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public void draw(SpriteBatch batcher) {
        textButton.draw(batcher, 1);
    }

    public boolean isTouchDown(int screenX, int screenY) {
        if (bounds.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(int screenX, int screenY) {
        if (bounds.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            return true;
        }
        return false;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
        textButton.setText(word);
    }
}
