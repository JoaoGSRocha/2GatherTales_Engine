package com.mygdx.game.Model;

public class Screen {
    private float fieldLeftEdge, fieldRightEdge, fieldUpEdge, fieldDownEdge;

    private int screenWidth, screenHeight;

    public Screen(int fieldLeftEdge, int fieldRightEdge, int fieldUpEdge,
                  int fieldDownEdge) {
        this.fieldLeftEdge = fieldLeftEdge;
        this.fieldRightEdge = fieldRightEdge;
        this.fieldUpEdge = fieldUpEdge;
        this.fieldDownEdge = fieldDownEdge;
    }

    public float getFieldLeftEdge() { return fieldLeftEdge; }

    public void setFieldLeftEdge(float fieldLeftEdge) {
        this.fieldLeftEdge = fieldLeftEdge;
    }

    public float getFieldRightEdge() { return fieldRightEdge; }

    public void setFieldRightEdge(float fieldRightEdge) {
        this.fieldRightEdge = fieldRightEdge;
    }

    public float getFieldUpEdge() { return fieldUpEdge; }

    public void setFieldUpEdge(float fieldUpEdge) {
        this.fieldUpEdge = fieldUpEdge;
    }

    public float getFieldDownEdge() { return fieldDownEdge; }

    public void setFieldDownEdge(float fieldDownEdge) {
        this.fieldDownEdge = fieldDownEdge;
    }

    public int getScreenWidth() { return screenWidth; }

    public void setScreenWidth(int screenWidth) { this.screenWidth = screenWidth; }

    public int getScreenHeight() { return screenHeight; }

    public void setScreenHeight(int screenHeight) { this.screenHeight = screenHeight; }
}
