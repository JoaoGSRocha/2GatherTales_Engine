package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Game2D;
import com.mygdx.game.JSON.JSONParser;

public class MenuScreens implements Screen {

    private Game2D parent;
    private Stage stage;

    Skin skin = new Skin(Gdx.files.internal("flat/skin/skin.json"));

    public MenuScreens(Game2D game) {
        parent = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        showMain();
    }

    public void showMain(){
        Gdx.graphics.setResizable(false);
        stage.clear();
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        //create Labels
        Label titleGameLabel = new Label(parent.gameName,skin);

        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);

        //add buttons to table
        table.add(titleGameLabel).fillX().uniformX();
        table.row().spaceTop(20);
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(parent.CINEMATIC_SCREEN);
                new JSONParser();
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //pbrShader.albedoColor.x=audioSlider.getValue();
                showSettings();
            }
        });
    }

    public void showSettings()
    {
        stage.clear();
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        //Create Buttons
        TextButton btnBack = new TextButton("Back to Menu",skin);

        //Create Slider
        Slider audioSlider = new Slider(0, 1, 0.05f, false, skin);
        audioSlider.setValue(parent.gameSoundVolume);

        //Create Labels
        Label audioLabel = new Label("Sound Volume:",skin);

        //add Elements to table
        table.add(audioLabel).fillX().uniformX();
        table.add(audioSlider).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(btnBack).fillX().uniformX();

        // create listeners
        btnBack.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //pbrShader.albedoColor.x=audioSlider.getValue();
                showMain();
            }
        });

        audioSlider.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                //pbrShader.albedoColor.x=audioSlider.getValue();
                parent.gameSoundVolume=audioSlider.getValue();
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
