package com.timetelling.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.timetelling.helper.AssetLoader;

public class ImgButton {

    private Rectangle bounds;
    private Texture texture;
    private boolean isPressed = false;
    private String word;
    private BitmapFont font;
    private float textX, textY;
    private float wrapPercentage;

    public ImgButton(float x, float y, float width, float height, String word, Texture texture, BitmapFont font, float textX, float textY) {
        this.word = word;
        this.bounds = new Rectangle(x, y, width, height);
        this.texture = texture;
        isPressed = false;
        this.font = font;
        this.textX = textX;
        this.textY = textY;
        wrapPercentage = 0;
    }

    public ImgButton(float x, float y, float width, float height, String word, Texture texture, BitmapFont font) {
        this.word = word;
        this.bounds = new Rectangle(x, y, width, height);
        this.texture = texture;
        isPressed = false;
        this.font = font;
        this.textX = 0;
        this.textY = 0;
        wrapPercentage = 0;
    }

    public void setWrapPercentage(float wrapPercentage) {
        this.wrapPercentage = wrapPercentage;
    }

    public boolean isClicked(int screenX, int screenY) {
        return bounds.contains(screenX, screenY);
    }

    public void draw(SpriteBatch batcher) {
        batcher.draw(texture, bounds.x, bounds.y, bounds.width, bounds.height);
        font.draw(batcher, word, bounds.x + textX + bounds.width*wrapPercentage/2, bounds.y + textY + bounds.height/2 + font.getCapHeight()/2, bounds.width*(1-wrapPercentage), Align.center, true);
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

    public void setWord(String word) {
        this.word = word;
    }

}
