package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.JSON.JSONParser;
import com.mygdx.game.UI.AnswersScreens;
import com.mygdx.game.UI.CinematicScreens;
import com.mygdx.game.UI.MenuScreens;

public class Game2D extends Game {

	public final static int MAIN_MENU = 0;
	public final static int CINEMATIC_SCREEN_MAIN = 1;
	public final static int CINEMATIC_SCREEN = 2;
	public final static int ANSWER_SCREEN = 3;
	public float gameSoundVolume=0.5f;
	public Preferences prefs;
	public final static String gameName = "Easnamh";
	public static Skin skin;
	private Screen mainScreen;
	private Screen cinematicScreen;
	private Screen answerScreen;

	@Override
	public void create() {
		prefs = Gdx.app.getPreferences("Easnamh");
		Gdx.graphics.setTitle(gameName);
		Gdx.graphics.setResizable(false);
		Gdx.graphics.setWindowedMode(1000,563);

		JSONParser jsonParser = new JSONParser();
		
		if(!prefs.contains("gameSoundVolume")) {
			prefs.putFloat("gameSoundVolume",0.5f);
			prefs.flush();
		}else{
			gameSoundVolume=prefs.getFloat("gameSoundVolume");
		}

		skin = new Skin(Gdx.files.internal("flat/skin/skin.json"));

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
			case CINEMATIC_SCREEN_MAIN:
				cinematicScreen = new CinematicScreens(this, JSONParser.cinematics, 0);
				this.setScreen(cinematicScreen);
				break;
		}
	}

	public void changeScreen(int screen, int key){
		switch(screen){
			case MAIN_MENU:
				mainScreen = new MenuScreens(this);
				this.setScreen(mainScreen);
				break;
			case CINEMATIC_SCREEN_MAIN:
				cinematicScreen = new CinematicScreens(this, JSONParser.cinematics, 0);
				this.setScreen(cinematicScreen);
				break;
			case CINEMATIC_SCREEN:
				cinematicScreen = new CinematicScreens(this, JSONParser.cinematics, key-1);
				this.setScreen(cinematicScreen);
				break;
			case ANSWER_SCREEN:
				answerScreen = new AnswersScreens(this, JSONParser.questions, key-1);
				this.setScreen(answerScreen);
		}
	}
}