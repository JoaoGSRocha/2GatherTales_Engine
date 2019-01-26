package com.mygdx.game.Model.Parser;

public class Answer  implements Triggerable {
    private String text;
    private Key triggerKey;
    private  Integer serialnumber;
    private String type;

    public Integer getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
