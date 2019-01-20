package com.mygdx.game;

import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.JSON.JSONParser;
import com.mygdx.game.Model.PlayerCursor;
import com.mygdx.game.Model.Screen;
import com.mygdx.game.UI.UI_Render;

public class Game2D extends ApplicationAdapter {

	private Screen screen;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private FitViewport viewport;
	private Rectangle currMousePos;
	PlayerCursor playerCursor;
	private SpriteAnimation spriteAnim;
	private Animator anim;
	private DialogRect dialogRect;
	private ShapeRenderer shapeRenderer;
	private boolean mining = false;
	BitmapFont font;
	Map<Rectangle, Integer> map;
	Input input;
	UI_Render ui_render;


	@Override
	public void create() {
		playerCursor = new PlayerCursor();
		ui_render = new UI_Render();
		ui_render.stage_Init();

		JSONParser jsonParser = new JSONParser();
		jsonParser.load();

		playerCursor.setPositionX(350);
		playerCursor.setPositionY(220);

		input = new Input();
		screen = new Screen(0, 800,
				0, 480);

		font = new BitmapFont(Gdx.files.internal("firstryFont.fnt"));

		// create the camera and the SpriteBatch
		camera = new OrthographicCamera();
		viewport = new FitViewport(1920, 1080,camera);
		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
		batch = new SpriteBatch();
		dialogRect = new DialogRect();
		shapeRenderer = new ShapeRenderer();


		// create a Rectangle to logically represent the bucket
        //If I ever need to detect collision of cursor against a button
		currMousePos = playerCursor.cursorRectangle();

		anim = new Animator();
		spriteAnim = new SpriteAnimation();
		anim.create();
		spriteAnim.create();
	}



	@Override
	public void render() {

		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		ui_render.stage_Render();
		spriteAnim.DrawSprite(batch, playerCursor.getPositionX(),
				playerCursor.getPositionY());

		//Trigger these for UI Animations that you might need
		if (mining) {
			anim.drawPickaxe(batch);
			anim.drawAxe(batch);
		}

		dialogRect.draw(batch, 0);
		batch.end();

		// process user input
		if(input.didCollide(50,50,50,50)){
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			playerCursor.setPositionX(touchPos.x-25) ;
			playerCursor.setPositionY(touchPos.y-25);
		}
	}

	@Override
	public void dispose() {
		// dispose of all the native resources
		batch.dispose();
		anim.dispose();
		spriteAnim.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
		camera.position.set(camera.viewportWidth/2,camera.viewportHeight/2,0);
	}

}