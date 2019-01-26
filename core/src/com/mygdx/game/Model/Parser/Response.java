package com.mygdx.game.Model.Parser;

import com.badlogic.gdx.utils.Disposable;

import java.util.ArrayList;
import java.util.HashMap;

public class Response implements Disposable {

    private Key key;
    private HashMap<Key, Answer> answer_al;
    private ArrayList<Cinematic> cinematic_al;
    private ArrayList<MainMenu> mainMenu_al;
    private ArrayList<Settings> settings_al;
    private  Integer serialnumber;
    private String type;



    public HashMap<Key, Answer> getAnswer_al() { return answer_al; }

    public void setAnswer_al(HashMap<Key, Answer> answer_al) {
        this.answer_al = answer_al;
    }

    public ArrayList<Cinematic> getCinematic_al() { return cinematic_al; }

    public void setCinematic_al(ArrayList<Cinematic> cinematic_al) {
        this.cinematic_al = cinematic_al;
    }

    public ArrayList<MainMenu> getMainMenu_al() { return mainMenu_al; }

    public void setMainMenu_al(ArrayList<MainMenu> mainMenu_al) {
        this.mainMenu_al = mainMenu_al;
    }

    public ArrayList<Settings> getSettings_al() { return settings_al; }

    public void setSettings_al(ArrayList<Settings> settings_al) {
        this.settings_al = settings_al;
    }

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

    @Override
    public void dispose() { }
}
