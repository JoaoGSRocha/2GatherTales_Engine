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
    TextButton button2;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;

    public void stage_Init(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        button = new UI_Logic().createButton("Button1",new int[]{0,100},new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Button1 Pressed");
            }
        });
        button2 = new UI_Logic().createButton("Button2",new int[]{0,200}, new ChangeListener() {
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Button2 Pressed");
            }
        });
        stage.addActor(button);
        stage.addActor(button2);
    }

    public void stage_Render(){
        stage.draw();
    }

}
