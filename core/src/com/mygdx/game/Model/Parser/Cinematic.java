package com.mygdx.game.Model.Parser;

public class Cinematic   {

    private String text;
    private Key triggerKey;
    private  Integer serialnumber;
    private String type;
    private String music;

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    private string music;

    private Integer trigger_serialnumber;
    private String trigger_type;
    private String backg;
    private String charac;

    public String getBackg() { return backg; }

    public void setBackg(String backg) { this.backg = backg; }

    public String getCharac() { return charac; }

    public void setCharac(String charac) { this.charac = charac; }

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
