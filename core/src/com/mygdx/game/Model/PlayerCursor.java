package com.mygdx.game.Model;

public class PlayerCursor {
    private int pcWidth, pcHeight;

    public PlayerCursor(int pcWidth, int pcHeight) {
        this.pcWidth = pcWidth;
        this.pcHeight = pcHeight;
    }

    public int getPcWidth() {
        return pcWidth;
    }

    public void setPcWidth(int pcWidth) {
        this.pcWidth = pcWidth;
    }

    public int getPcHeight() {
        return pcHeight;
    }

    public void setPcHeight(int pcHeight) {
        this.pcHeight = pcHeight;
    }
}
