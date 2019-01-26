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
import com.mygdx.game.Model.Parser.Answer;
import com.mygdx.game.Model.Parser.Cinematic;
import com.mygdx.game.Model.Parser.Key;
import com.mygdx.game.Model.Parser.Question;

import java.util.ArrayList;
import java.util.HashMap;

import static com.badlogic.gdx.Gdx.gl;

public class AnswersScreens implements Screen {

    private Game2D parent;
    private Stage stage;
    private Actor dialogRect;
    private ButtonFactory buttonFactory;
    private ArrayList<TextButton> buttonsAl;
    Skin skin = new Skin(Gdx.files.internal("flat/skin/skin.json"));

    public AnswersScreens(Game2D game, ArrayList<Question> questionsAl, int key) {
        parent = game;

        buttonFactory = new ButtonFactory();
        buttonsAl = buttonFactory.createAnswerButton_Al(parent,questionsAl,key);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        for(TextButton button: buttonsAl){
            stage.addActor(button);
        }
    }


    @Override
    public void render(float delta) {
        gl.glClearColor(0f, 0f, 0f, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
