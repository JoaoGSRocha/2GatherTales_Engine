package com.mygdx.game.Model.Parser;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

public class Response implements Disposable {

    private Key key;
    private ArrayList<Answer> answer_al;
    private ArrayList<Question> question_al;
    private ArrayList<Trigger> trigger_al;

    public Key getKey() { return key; }

    public void setKey(Key key) { this.key = key; }

    public ArrayList<Answer> getAnswer_al() { return answer_al; }

    public void setAnswer_al(ArrayList<Answer> answer_al) {
        this.answer_al = answer_al;
    }

    public ArrayList<Question> getQuestion_al() { return question_al; }

    public void setQuestion_al(ArrayList<Question> question_al) {
        this.question_al = question_al;
    }

    public ArrayList<Trigger> getTrigger_al() { return trigger_al; }

    public void setTrigger_al(ArrayList<Trigger> trigger_al) {
        this.trigger_al = trigger_al;
    }

    @Override
    public void dispose() {



    }
}
