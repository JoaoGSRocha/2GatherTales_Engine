package com.mygdx.game.Model.Parser;

public class Cinematic   {

    private String text;
    private Key triggerKey;
    private  Integer serialnumber;
    private String type;

    private Integer trigger_serialnumber;
    private String trigger_type;


    public Integer getSerialnumber() { return serialnumber; }


    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }


    public String getType() { return type; }


    public void setType(String type) { this.type = type; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

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
}
