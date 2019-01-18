package com.mygdx.game;

import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.game.Model.Screen;

public class Game2D extends ApplicationAdapter {

	private Screen screen;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle currPos;
	SpriteAnimation spriteAnim;
	private int pcWidth, pcHeight;
	Animator anim;
	DialogRect dialogRect;
	private boolean mining = false;

	private ShapeRenderer shapeRenderer;

	private static final float PLAYERX = 350;
	private static final float PLAYERY = 220;
	BitmapFont font;

	Map<Rectangle, Integer> map;

	Input input;

	@Override
	public void create() {

		input = new Input();

		screen = new Screen(0, 800-pcWidth,
				0, 480+pcHeight);

		dialogRect = new DialogRect();

		shapeRenderer = new ShapeRenderer();

		font = new BitmapFont(Gdx.files.internal("firstryFont.fnt"));



		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();

		// create a Rectangle to logically represent the bucket
		currPos = new Rectangle();
		currPos.x = 800 / 2 - 64 / 2; // center the bucket horizontally
		currPos.y = 20; // bottom left corner of the bucket is 20 pixels above the bottom screen edge
		currPos.width = 64;
		currPos.height = 64;

		Rectangle rectx = new Rectangle(30, 30, 30, 30);



		anim = new Animator();
		spriteAnim = new SpriteAnimation();
		anim.create();
		spriteAnim.create();
	}



	@Override
	public void render() {
		System.out.println(currPos.x+" "+currPos.y);
		Gdx.gl.glClearColor(1.13f, 0.84f, 0.75f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		
		spriteAnim.DrawSprite(batch, PLAYERX, PLAYERY);
		if (mining) {
			anim.drawPickaxe(batch);
			anim.drawAxe(batch);
		}

		dialogRect.draw(batch, 0);
		batch.end();

		// process user input

		input.calcInput(50,50,50,50);

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			currPos.x = -touchPos.x + 64 / 2;
		}

		


	}

	@Override
	public void dispose() {
		// dispose of all the native resources
		batch.dispose();
		anim.dispose();
		spriteAnim.dispose();
	}
}