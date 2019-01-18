package com.mygdx.game;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Game2D extends ApplicationAdapter {
	private Texture dropImage, blacksmithWorkshopImage, 
		merchantWharehouseImage, wharehouseImage, bucketImage, pebblesImage;
	private Sound dropSound;
	private Music rainMusic;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Rectangle currPos;
	SpriteAnimation spriteAnim;
	private Array<Rectangle> raindrops, sellingBuildings;
	private long lastDropTime;
	Animator anim;
	DialogRect dialogRect;
	private boolean mining = false;
	private float timeSinceCollision, timeWhileGathering;
	private ShapeRenderer shapeRenderer;
	private Rectangle toCompare;
	private static final float PLAYERX = 350;
	private static final float PLAYERY = 220;
	BitmapFont font;
	String counterTXT, dialogSellPickTXT, choiceSellPickTXT;
	int counter = 0;
	boolean disableDialog = false;
	private float pickaxeWAIT = 4f;
	private boolean skipDialog;
	private int price;
	private int fieldLeftEdge, fieldRightEdge, fieldUpEdge, fieldDownEdge;
	private int pcWidth, pcHeight;
	Map<Rectangle, Integer> map;

	Input input;

	@Override
	public void create() {

		input = new Input();

		fieldLeftEdge = 0;
		fieldRightEdge = 800-pcWidth;
		fieldUpEdge = 0;
		fieldDownEdge = 480+pcHeight;

		dialogRect = new DialogRect();

		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont(Gdx.files.internal("firstryFont.fnt"));
		counterTXT = "0";
		dialogSellPickTXT = "Would you like to buy \n a pickaxe?";
		choiceSellPickTXT = "Yes(1) No(2)";

		// load the images
		dropImage = new Texture(Gdx.files.internal("stone_small.png"));
		bucketImage = new Texture(Gdx.files.internal("Player.png"));
		blacksmithWorkshopImage = new Texture(Gdx.files.internal(
				"YourHouse.png"));
		merchantWharehouseImage = new Texture(Gdx.files.internal(
				"MerchantWharehouse.png"));
		wharehouseImage = new Texture(Gdx.files.internal(
				"Wharehouse_Piskel.png"));
		pebblesImage = new Texture(Gdx.files.internal("pebbles.png"));

		// load the drop sound effect and the rain background "music"
		dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		// start the playback of the background music immediately
		rainMusic.setLooping(true);
		rainMusic.play();

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

		// create the raindrops array and spawn the first raindrop
		raindrops = new Array<Rectangle>();
		spawnRaindrop();
		sellingBuildings = new Array<Rectangle>();
		map = new HashMap<Rectangle, Integer>();


		spawnSellingBuilding();	
		
		anim = new Animator();
		spriteAnim = new SpriteAnimation();
		anim.create();
		spriteAnim.create();
	}

	private void spawnRaindrop() {
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(-400, 400);
		raindrop.y = MathUtils.random(-200, 250);
		raindrop.width = 34;
		raindrop.height = 24;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}

	private void spawnSellingBuilding() {
		Rectangle sellingBuilding = new Rectangle();
		sellingBuilding.x = MathUtils.random(-400, 400);
		sellingBuilding.y = MathUtils.random(-200, 250);
		sellingBuilding.width = 300;
		sellingBuilding.height = 50;
		sellingBuildings.add(sellingBuilding);
	}

	private void calcSpawnSellBuild(SpriteBatch batch) {
		Iterator<Rectangle> iter = sellingBuildings.iterator();
		
		while (iter.hasNext()) {
			Rectangle sellingBuilding = iter.next();
			if(!map.containsKey(sellingBuilding)) {
				price = MathUtils.random(10, 20);
				map.put(sellingBuilding, price);
			}
			batch.draw(pebblesImage, 650, 50);
			font.draw(batch, counterTXT, 600, 105);
			if (new Rectangle(PLAYERX - currPos.x, PLAYERY - currPos.y, 64, 64)
					.overlaps(sellingBuilding) && !disableDialog) {
		
				String priceTXT = "\n"+map.get(sellingBuilding)+" pebbles";
				if (counter < price && Gdx.input.isKeyPressed(Keys.NUM_1)) {
					dialogSellPickTXT = "You do not have enough money \n "
							+ "You need "+price+" pebbles \n Alrighty(Enter)";
					choiceSellPickTXT = "";
					priceTXT = "";
				} else if (Gdx.input.isKeyPressed(Keys.NUM_1))
					disableDialog = true;
				font.draw(batch, dialogSellPickTXT, 200, 300);
				font.draw(batch, choiceSellPickTXT, 280, 200);
				font.draw(batch, priceTXT, 280, 100);
			}

			if (Gdx.input.isKeyPressed(Keys.ENTER)) {
				skipDialog = true;
				dialogSellPickTXT = "Would you like to buy \n a pickaxe?";
				choiceSellPickTXT = "Yes(1) No(2)";
			}
		}
		font.setColor(0, 0, 0, 1);
	}

	private void calcSpawnRain() {
		Iterator<Rectangle> iter = raindrops.iterator();
		while (iter.hasNext()) {
			Rectangle raindrop = iter.next();

			// Hold validation to see if you are still mining the same Rock
			if ((raindrop.overlaps(new Rectangle(
					PLAYERX - currPos.x, PLAYERY - currPos.y, 64, 64)))
					&& !raindrop.equals(toCompare))
				timeWhileGathering = 0;

			if (raindrop.overlaps(new Rectangle(
					PLAYERX - currPos.x, PLAYERY - currPos.y, 64, 64))) {
				timeSinceCollision = 0;
				timeWhileGathering += Gdx.graphics.getDeltaTime();
				mining = true;
				toCompare = raindrop;
			}

			timeSinceCollision += Gdx.graphics.getDeltaTime();
			if (timeSinceCollision > 1.5f && mining == true) {
				mining = false;
				timeSinceCollision = 0;
			}
			if (disableDialog)
				pickaxeWAIT = 2f;
			if (timeWhileGathering > pickaxeWAIT && mining == true) {
				iter.remove();
				dropSound.play();
				timeWhileGathering = 0;
				mining = false;
				counter++;
				counterTXT = String.valueOf(counter);
			}
		}
	}


	@Override
	public void render() {
		Gdx.gl.glClearColor(1.13f, 0.84f, 0.75f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);

		batch.begin();



		new TownMap().DrawBuildings(
				batch, currPos, blacksmithWorkshopImage,
				merchantWharehouseImage, wharehouseImage);

		for (Rectangle raindrop : raindrops)
			batch.draw(
					dropImage, raindrop.x + currPos.x, raindrop.y + currPos.y);
		
		for (Rectangle sellBuilding : sellingBuildings) 
			batch.draw(
					pebblesImage, sellBuilding.x + currPos.x,
					sellBuilding.y + currPos.y);
		
		spriteAnim.DrawSprite(batch, PLAYERX, PLAYERY);
		if (mining) {
			anim.drawPickaxe(batch);
			anim.drawAxe(batch);
		}

		calcSpawnSellBuild(batch);
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
		if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
			currPos.x += 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
			currPos.x -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W))
			currPos.y -= 200 * Gdx.graphics.getDeltaTime();
		if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S))
			currPos.y += 200 * Gdx.graphics.getDeltaTime();

		// make sure the bucket stays within the screen bounds
		if (currPos.x < fieldLeftEdge) {
			fieldLeftEdge -= 800;
			fieldRightEdge -= 800;
			currPos.x = fieldRightEdge;
			System.out.println(fieldLeftEdge);
		}
		if (currPos.x > fieldRightEdge) {
			fieldLeftEdge += 800;
			fieldRightEdge += 800;
			currPos.x = fieldLeftEdge;
			System.out.println(fieldLeftEdge);
		}
		if (currPos.y > fieldDownEdge) {
			fieldDownEdge += 480;
			fieldUpEdge += 480;
			currPos.y = fieldUpEdge;
			System.out.println(fieldDownEdge);
		}
		if (currPos.y < fieldUpEdge) {
			fieldDownEdge -= 480;
			fieldUpEdge -= 480;
			currPos.y = fieldDownEdge;
			System.out.println(fieldDownEdge);
		}
		
		// chMap<Rectangle, Integer> eck if we need to create a new raindrop
		if (TimeUtils.nanoTime() - lastDropTime > (1000000000 * 10000000)) {
			spawnRaindrop();
			spawnSellingBuilding();
		}

		// move the raindrops, remove any that are beneath the bottom edge of
		// the screen or that hit the bucket. In the later case we play back
		// a sound effect as well.
		calcSpawnRain();

	}

	@Override
	public void dispose() {
		// dispose of all the native resources
		dropImage.dispose();
		bucketImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		batch.dispose();
		anim.dispose();
		spriteAnim.dispose();
	}
}