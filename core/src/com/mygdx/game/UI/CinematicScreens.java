package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Game2D;
import com.mygdx.game.Model.Parser.Cinematic;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.gl;

public class CinematicScreens implements Screen {

    private Game2D parent;
    private Stage stage;
    private TextButton homeButton;
    private Cinematic cinematic;
    private ArrayList<Cinematic> cinematicAl = new ArrayList<Cinematic>();
    private int key;
    private Skin skin;
    private Label label;

    public CinematicScreens(Game2D game, ArrayList<Cinematic> cinematicAl, int key) {
        parent = game;
        skin = parent.skin;
        this.cinematicAl = cinematicAl;
        this.key = key;

        label = new Label(cinematicAl.get(key).getText(),skin);
        cinematic = cinematicAl.get(key);

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        loadImgs();
        label.setWrap(true);
        label.setColor(0f,0f,0f,1);

        Image cinematicBg = new Image(new TextureRegionDrawable(
                new TextureRegion(new Texture("box1.png"))));
        cinematicBg.setSize(1000,100);
        stage.addActor(cinematicBg);

        homeButton = new ButtonFactory().createBacktoMainButton(parent);
        stage.addActor(homeButton);

        // Pack label
        label.pack(); // This might not be necessary, unless you're changing other attributes such as font scale.

        // Manual sizing
        label.setWidth(Gdx.graphics.getWidth()); // Set the width directly
        label.pack(); // Label calculates it's height here, but resets width to 0 (bug?)
        label.setWidth(Gdx.graphics.getWidth()); // Set width again
        label.setX(15);
        label.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                switch(cinematic.getTrigger_type()){
                    case "cinematic":
                        parent.changeScreen(parent.CINEMATIC_SCREEN,cinematic.getTrigger_serialnumber());
                        break;
                    case "answer":
                        parent.changeScreen(parent.ANSWER_SCREEN,cinematic.getTrigger_serialnumber());
                        break;
                    case "END":
                        parent.changeScreen(parent.END_SCREEN,0);
                        break;
                }
            }
        });
        stage.addActor(label);

        if(!cinematic.getMusic().equals("")){
            parent.menuSound.stop();
            parent.menuSound = Gdx.audio.newSound(Gdx.files.internal("music/"+cinematic.getMusic()));
            parent.menuSound.loop();
            parent.menuSound.play(parent.gameSoundVolume);
        }
    }

    public void loadImgs(){
        Image backg = new Image();
        Image charac = new Image();
        Table table = new Table();
        Table table2 = new Table();
        table.setFillParent(true);
        table2.setFillParent(true);
        if(this.cinematicAl.get(this.key).getBackg()!= null){
            backg = new Image(new TextureRegionDrawable(
                    new TextureRegion(new Texture(this.cinematicAl.get(this.key).getBackg()))));
            backg.setScaling(Scaling.fit);
            stage.addActor(table);
            table.add(backg).expand().fill();
        }
        if(this.cinematicAl.get(this.key).getCharac()!= null) {
            charac = new Image(new TextureRegionDrawable(
                    new TextureRegion(new Texture(this.cinematicAl.get(this.key).getCharac()))));
            charac.setScaling(Scaling.fit); // Default is Scaling.stretch, as you found.
            stage.addActor(table2);
            table2.add(charac).expand().fill();
        }




    }


    @Override
    public void render(float delta) {
        gl.glClearColor(0f, 0f, 0f, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        label.setWidth(Gdx.graphics.getWidth()-30);
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
