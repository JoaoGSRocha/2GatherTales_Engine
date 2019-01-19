package com.mygdx.game.Model;

import com.badlogic.gdx.math.Rectangle;

public class PlayerCursor {
    private Rectangle cursor;

    private float positionX;
    private float positionY;

    public PlayerCursor() {
        this.positionX = 350;
        this.positionY = 250;
    }

    public PlayerCursor(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Rectangle cursorRectangle(){
        // create a Rectangle to logically represent the bucket
        cursor = new Rectangle();
        cursor.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        cursor.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
        cursor.width = 64;
        cursor.height = 64;

        return cursor;
    }

    public float getPositionX() { return positionX; }

    public void setPositionX(float positionX) { this.positionX = positionX; }

    public float getPositionY() { return positionY; }

    public void setPositionY(float positionY) { this.positionY = positionY; }
}
