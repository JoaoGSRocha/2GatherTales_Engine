package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class Input {

    public boolean didCollide(float collider_X_max, float collider_X_min,
                              float collider_Y_max, float collider_Y_min) {
        Vector3 touchPos = new Vector3();

        if (Gdx.input.isTouched()) {
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);

            if (touchPos.x > collider_X_min && touchPos.x < collider_X_max)
                if (touchPos.y > collider_Y_min && touchPos.y < collider_Y_max)
                    return true;

            return false;
        }
        return  false;
    }
}