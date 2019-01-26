package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.JSON.JSONParser;
import com.mygdx.game.UI.CinematicScreens;
import com.mygdx.game.UI.MenuScreens;

public class Game2D extends Game {

	public final static int MAIN_MENU = 0;
	public final static int CINEMATIC_SCREEN = 1;
	public float gameSoundVolume=1;

	public final static String gameName = "Fuadaithe";

	private Screen mainScreen;
	private Screen cinematicScreen;

	@Override
	public void create() {
		Gdx.graphics.setTitle(gameName);
		Gdx.graphics.setResizable(false);
		Gdx.graphics.setWindowedMode(1000,563);

		JSONParser jsonParser = new JSONParser();

		mainScreen = new MenuScreens(this);
		this.setScreen(mainScreen);
	}

	@Override
	public void dispose() {

	}

	public void changeScreen(int screen){
		switch(screen){
			case MAIN_MENU:
				mainScreen = new MenuScreens(this);
				this.setScreen(mainScreen);
				break;
			case CINEMATIC_SCREEN:
				cinematicScreen = new CinematicScreens(this);
				this.setScreen(cinematicScreen);
				break;
		}
	}
}