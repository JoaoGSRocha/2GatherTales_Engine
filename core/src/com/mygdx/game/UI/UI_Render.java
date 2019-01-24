package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Model.Parser.Answer;

import java.util.ArrayList;

public class UI_Render  {
    Stage stage;
    TextButton button;
    TextButton button2;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    ArrayList<Answer> answerAl;
    ButtonFactory buttonFactory;
    ArrayList<TextButton> textButtonAl;

    public void stage_Init(){
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        answerAl = new ArrayList<Answer>();
        for(int x=0;x<3;x++){
            Answer answer = new Answer();
            answer.setText("Answer"+x);
            answerAl.add(answer);
        }
        buttonFactory = new ButtonFactory();
        textButtonAl = buttonFactory.createAnswerButton_Al(answerAl);
        for (TextButton textButton: textButtonAl) {
            stage.addActor(textButton);
        }
    }

    public void stage_Render(){
        stage.draw();
    }

}
