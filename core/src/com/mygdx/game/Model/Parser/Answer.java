package com.mygdx.game.Model.Parser;

public class Answer {
    private String text;
    private  Integer trigger_serialnumber;
    private String trigger_type;

    public Integer getTrigger_serialnumber() { return trigger_serialnumber; }

    public void setTrigger_serialnumber(Integer trigger_serialnumber) {
        this.trigger_serialnumber = trigger_serialnumber;
    }

    public String getTrigger_type() {
        return trigger_type;
    }

    public void setTrigger_type(String trigger_type) {
        this.trigger_type = trigger_type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
