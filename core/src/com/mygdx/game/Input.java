package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.HashMap;
import java.util.Map;

public class Input {


    private Texture dropImage, blacksmithWorkshopImage,
            merchantWharehouseImage, wharehouseImage, bucketImage, pebblesImage;
    private Sound dropSound;
    private Music rainMusic;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private float currPos;
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

    /*
    *
    * currPos - tracks coordinate of mouse cursor
    *
    * */
    public void calcInput(float colXUp, float colXDown, float colYUp, float colYDown) {

        // process user input
        if (Gdx.input.isTouched()) {

                currPos = (colXUp/colYUp) + (colXDown/colYDown);

        }
    }
}