package com.mygdx.game.Model.Parser;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;

public class Response implements Disposable, Triggerable {

    private Key key;
    private ArrayList<Answer> answer_al;
    private Key triggerkey;

    public Key getKey() { return key; }

    public void setKey(Key key) { this.key = key; }

    public ArrayList<Answer> getAnswer_al() { return answer_al; }

    public void setAnswer_al(ArrayList<Answer> answer_al) {
        this.answer_al = answer_al;
    }


    @Override
    public void dispose() { }

    @Override
    public Key getTriggerKey() { return triggerkey; }

    @Override
    public void setTriggerKey(Key key) { this.triggerkey = triggerkey; }
}
