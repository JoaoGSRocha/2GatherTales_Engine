package com.mygdx.game.Model.Parser;

public class MainMenu implements Triggerable{

    private String startBtn;
    private String settingsBtn;
    private String exitBtn;
    private Key triggerKey;

    @Override
    public Key getTriggerKey() {
        return triggerKey;
    }

    @Override
    public void setTriggerKey(Key key) {
        this.triggerKey = key;
    }
}
