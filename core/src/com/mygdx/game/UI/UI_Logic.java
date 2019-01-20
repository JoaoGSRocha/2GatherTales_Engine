package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class UI_Logic {

    public TextButton createButton(String txt, int[] coords, ChangeListener changeListener){
        BitmapFont font = new BitmapFont();
        Skin skin = new Skin(); // used for texturing the button's background
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        TextButton button = new TextButton(txt, textButtonStyle);
        button.addListener(changeListener);
        button.setPosition(coords[0],coords[1]);
        return button;
    }
}
