package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class TownMap {
   
   public void DrawBuildings(SpriteBatch batch, Rectangle currPos,
		   Texture black, Texture merch, Texture whare) {
      //Beginning Buildings
      batch.draw(black,			-30		+currPos.x, 	230	 	+currPos.y);
      batch.draw(whare, 		-230	+currPos.x,		391  	+currPos.y);
      batch.draw(merch,			-430	+currPos.x, 	246	 	+currPos.y);
      //+Buildings Part01
      batch.draw(whare, 		30		+currPos.x,		-391 	+currPos.y);
      batch.draw(whare, 		-130	+currPos.x, 	-391 	+currPos.y);
      batch.draw(whare, 		-330	+currPos.x,		-391 	+currPos.y);
      //+Buildings Part02
      batch.draw(whare, 		330		+currPos.x,		-291	+currPos.y);
      batch.draw(whare, 		530		+currPos.x,		-191  	+currPos.y);
      batch.draw(whare, 		630		+currPos.x,		-91 	+currPos.y);
      //+Buildings Part03
      batch.draw(whare, 		-530	+currPos.x,		-291 	+currPos.y );
      batch.draw(whare, 		-630	+currPos.x,		-191  	+currPos.y);
      batch.draw(whare, 		-730	+currPos.x,		-91 	+currPos.y);
   }
}