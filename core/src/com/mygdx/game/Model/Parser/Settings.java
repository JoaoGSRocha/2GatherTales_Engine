package com.mygdx.game.Model.Parser;

public class Settings implements  Triggerable{

    private float sfx;
    private float music;
    private Key triggerKey;

    public float getSfx() { return sfx; }

    public void setSfx(float sfx) { this.sfx = sfx; }

    public float getMusic() { return music; }

    public void setMusic(float music) { this.music = music; }

    @Override
    public Key getTriggerKey() {
        return triggerKey;
    }

    @Override
    public void setTriggerKey(Key key) { this.triggerKey = triggerKey; }
}
