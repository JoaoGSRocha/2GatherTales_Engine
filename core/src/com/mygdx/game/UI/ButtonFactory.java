package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Game2D;
import com.mygdx.game.Model.Parser.*;

import java.util.ArrayList;

public class ButtonFactory {

    private static final int START_X_VAL = 700;
    private static final int START_Y_VAL = 420;
    private static final int INC_Y_VAL = -120;

    UI_Logic ui_logic = new UI_Logic();

    public ArrayList<TextButton> createAnswerButton_Al(final Game2D parent, ArrayList<Question> questionsAl, int questionKey){
        ArrayList<TextButton> textButtonsAl = new ArrayList<TextButton>();
        int key = questionKey -1;
        int count = 0;
        for(final Answer answer : questionsAl.get(questionKey).getAnswers()){
            TextButton button = ui_logic.createButton(parent, answer.getText(),new float[]{START_X_VAL, START_Y_VAL + INC_Y_VAL * count},new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    switch(answer.getTrigger_type()){
                        case "cinematic":
                            parent.changeScreen(parent.CINEMATIC_SCREEN,answer.getTrigger_serialnumber());
                            break;
                        case "answer":
                            parent.changeScreen(parent.ANSWER_SCREEN,answer.getTrigger_serialnumber());
                            break;
                        case "END":
                            parent.changeScreen(parent.END_SCREEN,0);
                            break;
                    }

                }
            });
            textButtonsAl.add(button);
            count++;
        }
        return textButtonsAl;
    }

    public ArrayList<TextButton> createCinematicButton_Al(ArrayList<Cinematic> cinematic_al){
        ArrayList<TextButton> textButtons = new ArrayList<TextButton>();
        return textButtons;
    }

    public ArrayList<TextButton> createSettingsButton_Al(ArrayList<Settings> settings){
        ArrayList<TextButton> textButtons = new ArrayList<TextButton>();
        return textButtons;
    }

    public ArrayList<TextButton> createMainMenuButton_Al(ArrayList<MainMenu> mainMenus){
        ArrayList<TextButton> textButtons = new ArrayList<TextButton>();
        return textButtons;
    }


    public TextButton createBacktoMainButton(final Game2D parent){
        TextButton button = new UI_Logic().createButton(parent,"Home", new float[]{0, Gdx.graphics.getHeight()-20},
            new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                        parent.changeScreen(Game2D.MAIN_MENU);
                    }
                });
        return button;
    }
}
