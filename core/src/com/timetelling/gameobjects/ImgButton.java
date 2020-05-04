package com.timetelling.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.timetelling.helper.AssetLoader;

public class ImgButton {

    private Rectangle bounds;
    private Texture texture;
    private boolean isPressed = false;
    private String word;
    private BitmapFont font;
    private float textX, textY;

    public ImgButton(float x, float y, float width, float height, String word, Texture texture, BitmapFont font, float textX, float textY) {
        this.word = word;
        this.bounds = new Rectangle(x, y, width, height);
        this.texture = texture;
        isPressed = false;
        this.font = font;
        this.textX = textX;
        this.textY = textY;
    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public void draw(SpriteBatch batcher) {
        batcher.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
        font.draw(batcher, word, textX, textY);
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

}
