package com.mygdx.game.Model;

public class Screen {
    private int fieldLeftEdge, fieldRightEdge, fieldUpEdge, fieldDownEdge;

    public Screen(int fieldLeftEdge, int fieldRightEdge, int fieldUpEdge,
                  int fieldDownEdge) {
        this.fieldLeftEdge = fieldLeftEdge;
        this.fieldRightEdge = fieldRightEdge;
        this.fieldUpEdge = fieldUpEdge;
        this.fieldDownEdge = fieldDownEdge;
    }

    public int getFieldLeftEdge() { return fieldLeftEdge; }

    public void setFieldLeftEdge(int fieldLeftEdge) {
        this.fieldLeftEdge = fieldLeftEdge;
    }

    public int getFieldRightEdge() { return fieldRightEdge; }

    public void setFieldRightEdge(int fieldRightEdge) {
        this.fieldRightEdge = fieldRightEdge;
    }

    public int getFieldUpEdge() { return fieldUpEdge; }

    public void setFieldUpEdge(int fieldUpEdge) {
        this.fieldUpEdge = fieldUpEdge;
    }

    public int getFieldDownEdge() { return fieldDownEdge; }

    public void setFieldDownEdge(int fieldDownEdge) {
        this.fieldDownEdge = fieldDownEdge;
    }
}
