package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator{

	// Constant rows and columns of the sprite sheet
	private static final int FRAME_COLS = 2, FRAME_ROWS = 3;

	// Objects used
	Texture pickaxeSheet;
	Texture axeSheet;
	Animation<TextureRegion> pickaxeAnimation;
	Animation<TextureRegion> axeAnimation;

	// A variable for tracking elapsed time for the animation
	float stateTime;

	private float stateTime2;

	public void create() {

		// Load the sprite sheet as a Texture
		pickaxeSheet = new Texture(Gdx.files.internal("pickaxe_sheet.png"));
		axeSheet = new Texture(Gdx.files.internal("woodaxe_sheet.png"));

		// Use the split utility method to create a 2D array of TextureRegions. This is 
		// possible because this sprite sheet contains frames of equal size and they are 
		// all aligned.
		TextureRegion[][] tmp = TextureRegion.split(pickaxeSheet, 
				pickaxeSheet.getWidth() / FRAME_COLS,
				pickaxeSheet.getHeight() / FRAME_ROWS);
		
		TextureRegion[][] tmp2 = TextureRegion.split(axeSheet, 
				axeSheet.getWidth() / 2,
				axeSheet.getHeight() / 2);

		// Place the regions into a 1D array in the correct order, starting from the top 
		// left, going across first. The Animation constructor requires a 1D array.
		TextureRegion[] pickaxeFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				pickaxeFrames[index++] = tmp[i][j];
			}
		}
		
		TextureRegion[] axeFrames = new TextureRegion[2 * 2];
		int index2 = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				axeFrames[index2++] = tmp2[i][j];
			}
		}

		// Initialize the Animation with the frame interval and array of frames
		pickaxeAnimation = new Animation<TextureRegion>(0.025f, pickaxeFrames);
		axeAnimation = new Animation<TextureRegion>(0.025f, axeFrames);

		//	Reset the elapsed animation time to 0
		stateTime = 0f;
		stateTime2 = 0f;
	}

	public void drawPickaxe(SpriteBatch batch) {
		stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		
		TextureRegion currentFrame = pickaxeAnimation.getKeyFrame(stateTime*0.25f, true);
		batch.draw(currentFrame, 50, 50); // Draw current frame at (50, 50)
	}
	
	public void drawAxe(SpriteBatch batch) {
		stateTime2 += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
		TextureRegion axeFrame = axeAnimation.getKeyFrame(stateTime2*0.15f, true);
		batch.draw(axeFrame, 100, 50); // Draw current frame at (50, 50)
	}

	public void dispose() { // SpriteBatches and Textures must always be disposed
		pickaxeSheet.dispose();
		axeSheet.dispose();
	}


}
