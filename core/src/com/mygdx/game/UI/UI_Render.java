package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.Model.Parser.Question;
import com.mygdx.game.Model.Parser.Key;

import java.util.ArrayList;
import java.util.HashMap;

public class UI_Render  {
    Stage stage;
    TextButton button;
    TextButton button2;
    TextButton.TextButtonStyle textButtonStyle;
    BitmapFont font;
    Skin skin;
    HashMap<Key, Question> answerAl;
    ButtonFactory buttonFactory;
    ArrayList<TextButton> textButtonAl;

    public void stage_Init(){

    }

    public void stage_Render(){
        stage.draw();
    }

}
