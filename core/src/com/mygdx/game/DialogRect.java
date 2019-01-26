package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.Gdx.gl;

public class DialogRect extends Actor {

        private ShapeRenderer shapeRenderer;
        static private boolean projectionMatrixSet;

        public DialogRect(){
            shapeRenderer = new ShapeRenderer();
            projectionMatrixSet = false;
        }

        @Override
        public void draw(Batch batch, float alpha){

            batch.end();
            if(!projectionMatrixSet){
                shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
            }
            gl.glEnable(GL20.GL_BLEND);
            gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(new Color(.3f, .3f, 1.0f, 0.5f));
            int height = Gdx.graphics.getHeight();
            int width = Gdx.graphics.getWidth();
            shapeRenderer.rect(0, 0, width, 100);
            shapeRenderer.end();
            gl.glDisable(GL20.GL_BLEND);
            batch.begin();
        }
}
