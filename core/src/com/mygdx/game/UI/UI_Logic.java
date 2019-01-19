package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class UI_Logic {

    public TextButton createButton(String txt){
        BitmapFont font = new BitmapFont();
        Skin skin = new Skin();
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        TextButton button = new TextButton(txt, textButtonStyle);
        return button;
    }
}
