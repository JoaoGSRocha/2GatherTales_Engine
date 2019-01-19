package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
public class UI_Render  {
    Stage stage;
    TextButton button;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;

    public void stage_Init(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        font = new BitmapFont(Gdx.files.internal("firstryFont.fnt"));
        skin = new Skin();
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        button = new TextButton("Button1", textButtonStyle);
        button.addListener(new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Button Pressed");
            }
        });
        stage.addActor(button);
    }

    public void stage_Render(){
        stage.draw();
    }

}
