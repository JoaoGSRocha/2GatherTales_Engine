package com.mygdx.game.Model.Parser;

import java.util.ArrayList;

public class Question {
    private  Integer serialnumber;
    private String type;
    private String question;
    private String backg;
    private String charac;

    public String getBackg() { return backg; }

    public void setBackg(String backg) { this.backg = backg; }

    public String getCharac() { return charac; }

    public void setCharac(String charac) { this.charac = charac; }

    ArrayList<Answer> answers = new ArrayList<Answer>();

    public ArrayList<Answer> getAnswers() { return answers; }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestion() { return question; }

    public void setQuestion(String question) { this.question = question; }

    public Integer getSerialnumber() { return serialnumber; }

    public void setSerialnumber(Integer serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTriggerKey(Key key) {

    }
}
