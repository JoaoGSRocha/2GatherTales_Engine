package com.mygdx.game.UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Game2D;

public class UI_Logic {

    public TextButton createButton(Game2D parent, String txt, float[] coords,
                                   ChangeListener changeListener){
        BitmapFont font = new BitmapFont();
        Skin skin = parent.skin; // used for texturing the button's background
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.font = font;
        TextButton button = new TextButton(txt, skin);
        button.addListener(changeListener);
        button.setPosition(coords[0],coords[1]);
        return button;
    }
}
