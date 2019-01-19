package com.mygdx.game.Model;

import com.badlogic.gdx.math.Rectangle;

public class PlayerCursor {
    private Rectangle cursor;

    public Rectangle cursorRectangle(){
        // create a Rectangle to logically represent the bucket
        cursor = new Rectangle();
        cursor.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        cursor.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
        cursor.width = 64;
        cursor.height = 64;

        return cursor;
    }
}
