package com.mygdx.game.UI;

import com.mygdx.game.Model.Parser.Answer;

import java.util.ArrayList;

public class ButtonFactory {

    UI_Logic ui_logic = new UI_Logic();

    public void createAnswerButton(ArrayList<Answer> answer_al) {
        for(Answer answer : answer_al)
            ui_logic.createButton(answer.toString());
    }
}
