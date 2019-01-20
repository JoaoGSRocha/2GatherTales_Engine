package com.mygdx.game.UI;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Model.Parser.Answer;

import java.util.ArrayList;

class CoordsCalc {
    private static  final int START_X_VAL = 100;
    private static  final int START_Y_VAL = 100;
    private static  final int INC_X_VAL = 40;
    private static  final int INC_Y_VAL = 40;

    public ArrayList<ButtonPosition> giveButtonPosition_AL(
            ArrayList<Answer> answer_al){
        ArrayList<ButtonPosition> buttonPosition_al =
                new ArrayList<ButtonPosition>();
        ButtonPosition buttonPosition;

        int counter = 0;
        for (int i=0; i<answer_al.size(); i++){
            buttonPosition = new ButtonPosition(
                    START_X_VAL + INC_X_VAL * counter,
                    START_Y_VAL + INC_Y_VAL * counter);
            counter++;
            buttonPosition_al.add(buttonPosition);
        }

        return buttonPosition_al;
    }


}

public class ButtonFactory {

    UI_Logic ui_logic = new UI_Logic();


    public void createAnswerButton(ArrayList<Answer> answer_al) {
        ArrayList<ButtonPosition> buttonPosition_al =
                new CoordsCalc().giveButtonPosition_AL(answer_al);
        for(int i = 0; i< buttonPosition_al.size(); i++) {

            float posX = buttonPosition_al.get(i).getPos_X();
            float posY = buttonPosition_al.get(i).getPos_Y();
            String title = answer_al.get(i).getText();

            ui_logic.createButton(title, new float[]{ posX, posY},
            new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {

                }
            });
        }
    }
}
