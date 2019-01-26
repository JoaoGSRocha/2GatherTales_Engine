package com.mygdx.game.Model.Parser;

public class Answer  implements Triggerable {
    private String text;
    private Key triggerKey;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Key getTriggerKey() {
        return triggerKey;
    }

    @Override
    public void setTriggerKey(Key key) {

    }
}
