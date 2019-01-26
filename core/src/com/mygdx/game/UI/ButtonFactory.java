package com.mygdx.game.UI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Game2D;
import com.mygdx.game.Model.Parser.*;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.HashMap;

class CoordsCalc {
    private static  final int START_X_VAL = 500;
    private static  final int START_Y_VAL = 50;
    private static  final int INC_X_VAL = 0;
    private static  final int INC_Y_VAL = 40;

    public ArrayList<ButtonPosition> giveButtonPosition_AL(){
        ArrayList<ButtonPosition> buttonPosition_al =
                new ArrayList<ButtonPosition>();
        ButtonPosition buttonPosition;

        for (int i=0; i<4; i++){
            buttonPosition = new ButtonPosition(
                    START_X_VAL + INC_X_VAL * i,
                    START_Y_VAL + INC_Y_VAL * i);
            buttonPosition_al.add(buttonPosition);
        }

        return buttonPosition_al;
    }


}

public class ButtonFactory {

    UI_Logic ui_logic = new UI_Logic();


    /*public ArrayList<TextButton> createAnswerButton_Al(final HashMap<Key, Answer> answer_al) {
        ArrayList<TextButton> textButtonAl = new ArrayList<TextButton>();
        ArrayList<ButtonPosition> buttonPosition_al =
                new CoordsCalc().giveButtonPosition_AL(answer_al);
        for(int i = 0; i< buttonPosition_al.size(); i++) {

            float posX = buttonPosition_al.get(i).getPos_X();
            float posY = buttonPosition_al.get(i).getPos_Y();
          //  String text = answer_al.get(finalI).getText();
          //  Key key = answer_al.get(finalI).getTriggerKey();
            String title = answer_al.get(i).getText();

            final int finalI = i;
            TextButton button = ui_logic.createButton(title, new float[]{ posX, posY},
            new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    //ChangedAnswers(a);
                    Key key = answer_al.get(finalI).getTriggerKey();

                }
            });

            textButtonAl.add(button);
        }
        return textButtonAl;
    }*/

    public ArrayList<TextButton> createAnswerButton_Al(ArrayList<Answer> answersAl, int questionKey){
        ArrayList<TextButton> textButtonsAl = new ArrayList<TextButton>();
        int key = questionKey -1;
        CoordsCalc coordsCalc = new CoordsCalc();
        ArrayList<ButtonPosition> buttonPositionAl = coordsCalc.giveButtonPosition_AL();
        for(int x=key*4;x<(key*4)+4;x++){
            int count = 0;
            final int curX = x;
            TextButton button = ui_logic.createButton(answersAl.get(x).getText(),new float[]{buttonPositionAl.get(count).getPos_X(), buttonPositionAl.get(count).getPos_Y()},new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    //ChangedAnswers(a);
                    Key key = answersAl.get(curX).getTriggerKey();
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
        TextButton button = new UI_Logic().createButton("Home", new float[]{0, Gdx.graphics.getHeight()-20},
            new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                        parent.changeScreen(Game2D.MAIN_MENU);
                    }
                });
        return button;
    }
}
