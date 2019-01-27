package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.DialogRect;
import com.mygdx.game.Game2D;
import com.mygdx.game.JSON.JSONParser;
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
    private  ArrayList<Question> questionsA1 = new ArrayList<Question>();
    private Actor dialogRect;
    private ButtonFactory buttonFactory;
    private ArrayList<TextButton> buttonsAl;
    private  int key;
    private Label label;
    Skin skin;

    public AnswersScreens(Game2D game, ArrayList<Question> questionsAl, int key) {
        parent = game;
        skin = parent.skin;
        this.questionsA1 = questionsAl;
        this.key = key;


        buttonFactory = new ButtonFactory();
        buttonsAl = buttonFactory.createAnswerButton_Al(parent,questionsAl,key);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        loadImgs();
        for(TextButton button: buttonsAl){
            button.getLabelCell().width(200);
            button.getLabel().setWrap(true);
            button.invalidate();
            button.setWidth(200);
            button.setHeight(100);
            stage.addActor(button);
        }

        Image questionBg = new Image(new TextureRegionDrawable(
                new TextureRegion(new Texture("box3.png"))));

        questionBg.setSize(335,300);
        stage.addActor(questionBg);

        label = new Label(questionsA1.get(key).getQuestion(),skin);
        label.setColor(0f,0f,0f,1);
        label.setWrap(true);
        label.setWidth(300);
        label.setX(20);
        label.setY(200-label.getHeight());
        stage.addActor(label);

    }

    public void loadImgs(){
        Table table = new Table();
        Table table2 = new Table();
        table.setFillParent(true);
        table2.setFillParent(true);
        Image backg = new Image(new TextureRegionDrawable(
                new TextureRegion(new Texture(this.questionsA1.get(key).getBackg()))));
        Image charac = new Image(new TextureRegionDrawable(
                new TextureRegion(new Texture(this.questionsA1.get(key).getCharac()))));
        charac.setScaling(Scaling.fit); // Default is Scaling.stretch, as you found.
        stage.addActor(table);
        stage.addActor(table2);
        table.add(backg).expand().fill();
        table2.add(charac).expand().fill();
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
