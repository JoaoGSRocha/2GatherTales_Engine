package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.DialogRect;
import com.mygdx.game.Game2D;

import static com.badlogic.gdx.Gdx.gl;

public class CinematicScreens implements Screen {

    private Game2D parent;
    private Stage stage;
    private Actor dialogRect;
    private TextButton homeButton;
    private Skin skin = new Skin(Gdx.files.internal("flat/skin/skin.json"));
    private Label label = new Label("Text goes here test how long can this be lmao ok lorem ipsum no really why am I still writing lol ok I'll stop I swearText goes here test how long can this be lmao ok lorem ipsum no really why am I still writing lol ok I'll stop I swearText goes here test how long can this be lmao ok lorem ipsum no really why am I still writing lol ok I'll stop I swearText goes here test how long can this be lmao ok lorem ipsum no really why am I still writing lol ok I'll stop I swearText goes here test how long can this be lmao ok lorem ipsum no really why am I still writing lol ok I'll stop I swear",skin);

    public CinematicScreens(Game2D game/*, ArrayList<Cinematic> cinematicAl, String key*/) {
        parent = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        label.setWrap(true);

        dialogRect = new DialogRect();
        stage.addActor(dialogRect);

        homeButton = new ButtonFactory().createBacktoMainButton(parent);
        stage.addActor(homeButton);

        // Pack label
        label.pack(); // This might not be necessary, unless you're changing other attributes such as font scale.

        // Manual sizing
        label.setWidth(Gdx.graphics.getWidth()); // Set the width directly
        label.pack(); // Label calculates it's height here, but resets width to 0 (bug?)
        label.setWidth(Gdx.graphics.getWidth()); // Set width again
        stage.addActor(label);
    }


    @Override
    public void render(float delta) {
        gl.glClearColor(0f, 0f, 0f, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        label.setWidth(Gdx.graphics.getWidth());
        label.setY(20f);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
