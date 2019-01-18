package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class Spawner {
	private Array<Rectangle> raindrops;
	private long lastDropTime;
	private boolean mining = false;
	
		public void create() {
		      raindrops = new Array<Rectangle>();
		      
		}
	   private void spawnRaindrop() {
		      Rectangle raindrop = new Rectangle();
		      raindrop.x = MathUtils.random(0, 800-64);
		      raindrop.y = 480;
		      raindrop.width = 64;
		      raindrop.height = 64;
		      raindrops.add(raindrop);
		      lastDropTime = TimeUtils.nanoTime();
		   }

}
