package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Game2D;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.SpriteAnimation;
import com.mygdx.game.Animator;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new 
				LwjglApplicationConfiguration(); 
		new LwjglApplication(new Game2D(), config);
	}
}
