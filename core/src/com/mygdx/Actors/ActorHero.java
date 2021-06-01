package com.mygdx.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ActorHero extends Actor {

    public SpriteBatch spriteBatch;
    private Texture textureHero;
    private TextureRegion textureRegionHero;
    private float life = 100f;

    private boolean MainGameScreenStop = false;
    private Texture textureHeroAttack;
    private boolean alive;
    private Sprite spriteHero;

    private final float STEP = 5f;
    private static final int FRAME_COLS = 3; // #1
    private static final int FRAME_ROWS = 1; // #2
    private int yCount = 0;

    private Animation jumpAnimation;

    private Animation walkAnimation; // #3
    private Animation attackAnimation;
    private TextureRegion[] attackFrames; // #5

    private Texture walkSheet; // #4
    private TextureRegion[] walkFrames; // #5
    public TextureRegion currentFrame; // #7
    public float stateTime; // #8

    private boolean isHeroLookRight = true;
    private boolean isHeroLookLeft = false;
    private boolean firstPressed = true;
    private boolean needJump = false;

    private boolean jumpUp = true;
    private boolean jumpDown = false;


    public final float HERO_STEP = 2f;

    private final float JUMP_STEP_1 = 5f;
    private final float JUMP_STEP_2 = 2.5f;
    private final float JUMP_STEP_3 = 1.2f;
    private final float JUMP_STEP_4 = 0.7f;

    public void setMainGameScreenStop(boolean mainGameScreenStop) {
        MainGameScreenStop = mainGameScreenStop;
    }

    public boolean isMainGameScreenStop() {
        return MainGameScreenStop;
    }

    public float getJUMP_STEP_1() {
        return JUMP_STEP_1;
    }

    public float getJUMP_STEP_2() {
        return JUMP_STEP_2;
    }

    public float getJUMP_STEP_3() {
        return JUMP_STEP_3;
    }

    public float getJUMP_STEP_4() {
        return JUMP_STEP_4;
    }

    public float getSTEP() {
        return STEP;
    }

    public void setTextureHero(Texture textureHero) {
        this.textureHero = textureHero;
    }

    public void setSpriteHero(Sprite spriteHero) {
        this.spriteHero = spriteHero;
    }

    public void setTextureRegionHero(TextureRegion textureRegionHero) {
        this.textureRegionHero = textureRegionHero;
    }

    public boolean isNeedJump() {
        return needJump;
    }

    public boolean isFirstPressed() {
        return firstPressed;
    }

    public void setFirstPressed(boolean firstPressed) {
        this.firstPressed = firstPressed;
    }

    public void setSpriteHeroPosition(float x, float y){ this.spriteHero.setPosition(x, y); }

    public void setHeroLookRight(boolean heroLookRight) {
        isHeroLookRight = heroLookRight;
    }

    public void setHeroLookLeft(boolean heroLookLeft) {
        isHeroLookLeft = heroLookLeft;
    }

    public void isHeroJump(boolean needJump) {
        this.needJump = needJump;
    }


    public void isHeroRun(Texture walkSheet) {
        this.walkSheet = walkSheet;
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;

        for (int i = 0; i < FRAME_ROWS; i++)
        {
            for (int j = 0; j < FRAME_COLS; j++)
            {
                walkFrames[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation(0.005f, walkFrames); // #11
        spriteBatch = new SpriteBatch(); // #12
        stateTime = 0f; // #13

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime() * 4; // #15
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true); // #16

        textureRegionHero = new TextureRegion(currentFrame);
        spriteHero = new Sprite(textureRegionHero);

        spriteBatch.begin();
        spriteBatch.end();
    }

    public void isHeroRun() {
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;

        for (int i = 0; i < FRAME_ROWS; i++)
        {
            for (int j = 0; j < FRAME_COLS; j++)
            {
                walkFrames[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation(0.005f, walkFrames); // #11
        spriteBatch = new SpriteBatch(); // #12
        stateTime = 0f; // #13

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime() * 4; // #15
        currentFrame = (TextureRegion) walkAnimation.getKeyFrame(stateTime, true); // #16

        textureRegionHero = new TextureRegion(currentFrame);
        spriteHero = new Sprite(textureRegionHero);

        spriteBatch.begin();
        spriteBatch.end();
    }


    public void isHeroAttack(Texture textureHeroAttack) {
        this.textureHeroAttack = textureHeroAttack;
        TextureRegion[][] tmp = TextureRegion.split(textureHeroAttack, textureHeroAttack.getWidth() / FRAME_COLS, textureHeroAttack.getHeight() / FRAME_ROWS);
        attackFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;

        for (int i = 0; i < FRAME_ROWS; i++)
        {
            for (int j = 0; j < FRAME_COLS; j++)
            {
                attackFrames[index++] = tmp[i][j];
            }
        }

        attackAnimation = new Animation(0.005f, attackFrames); // #11
        spriteBatch = new SpriteBatch(); // #12
        stateTime = 0f; // #13

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); // #14
        stateTime += Gdx.graphics.getDeltaTime() * 4; // #15
        currentFrame = (TextureRegion) attackAnimation.getKeyFrame(stateTime, true); // #16

        textureRegionHero = new TextureRegion(currentFrame);
        spriteHero = new Sprite(textureRegionHero);

        spriteBatch.begin();
        spriteBatch.end();
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ActorHero(Texture textureHero) {
        this.textureHero = textureHero;
        textureRegionHero = new TextureRegion(this.textureHero);
        this.alive=true;
        spriteHero = new Sprite(textureRegionHero);
        setSize(spriteHero.getRegionWidth(), spriteHero.getRegionHeight());
    }


    public void act (float delta)
    {
        super.act(delta);

        if(needJump)
        {
            if (yCount == 0 && jumpUp) {
                if(isHeroLookRight) {
                    textureHero = new Texture("characters/jumpingRight.png");
                    textureRegionHero = new TextureRegion(textureHero);
                    spriteHero = new Sprite(textureRegionHero);
                }else{
                    textureHero = new Texture("characters/jumpingLeft.png");
                    textureRegionHero = new TextureRegion(textureHero);
                    spriteHero = new Sprite(textureRegionHero);
                }
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() + getJUMP_STEP_1());
                this.setPosition(this.getX(), this.getY() + getJUMP_STEP_1());
                yCount++;
            }


            if (yCount > 0 && yCount < 25 && jumpUp) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() + getJUMP_STEP_1());
                this.setPosition(this.getX(), this.getY() + getJUMP_STEP_1());
                yCount++;
            }
            if (yCount >= 25 && yCount < 40 && jumpUp) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() + getJUMP_STEP_2());
                this.setPosition(this.getX(), this.getY() + getJUMP_STEP_2());
                yCount++;
            }
            if (yCount >= 40 && yCount < 53 && jumpUp) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() + getJUMP_STEP_3());
                this.setPosition(this.getX(), this.getY() + getJUMP_STEP_3());
                yCount++;
            }
            if (yCount >= 53 && yCount < 60 && jumpUp) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() + getJUMP_STEP_4());
                this.setPosition(this.getX(), this.getY() + getJUMP_STEP_4());
                yCount++;
            }


            if (yCount == 60 && jumpUp) {
                jumpUp = false;
                jumpDown = true;
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() - getJUMP_STEP_4());
                this.setPosition(this.getX(), this.getY() - getJUMP_STEP_4());
                yCount--;
            }


            if (yCount >= 53 && yCount < 61 && jumpDown) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() - getJUMP_STEP_4());
                this.setPosition(this.getX(), this.getY() - getJUMP_STEP_4());
                yCount--;
            }
            if (yCount >= 40 && yCount < 53 && jumpDown) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() - getJUMP_STEP_3());
                this.setPosition(this.getX(), this.getY() - getJUMP_STEP_3());
                yCount--;
            }
            if (yCount >= 25 && yCount < 40 && jumpDown) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() - getJUMP_STEP_2());
                this.setPosition(this.getX(), this.getY() - getJUMP_STEP_2());
                yCount--;
            }
            if (yCount > 0 && yCount < 25 && jumpDown) {
                spriteHero.setPosition(spriteHero.getX(), spriteHero.getY() - getJUMP_STEP_1());
                this.setPosition(this.getX(), this.getY() - getJUMP_STEP_1());
                yCount--;
            }


            if (yCount == 0 && jumpDown) {
                needJump = false;
                jumpUp = true;
                jumpDown = false;
            }
        }

        if (!Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Gdx.input.isKeyPressed(Input.Keys.UP) && !Gdx.input.isKeyPressed(Input.Keys.DOWN) && !needJump && !isMainGameScreenStop()) {
            if(isHeroLookLeft) {
                textureHero = new Texture("characters/standingLeft.png");
                textureRegionHero = new TextureRegion(textureHero);
                spriteHero = new Sprite(textureRegionHero);
            }else{
                textureHero = new Texture("characters/standingRight.png");
                textureRegionHero = new TextureRegion(textureHero);
                spriteHero = new Sprite(textureRegionHero);
            }
        }


        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

            if(!needJump) {
                walkSheet = new Texture("characters/runningLeft.png"); // #9

                isHeroRun(walkSheet);

                spriteHero.setPosition(getX() - HERO_STEP - 5, getY());
                this.setPosition(getX() - HERO_STEP - 5, getY());

                this.isHeroLookRight = false;
                this.isHeroLookLeft = true;
            }else{
                spriteHero.setPosition(getX() - HERO_STEP - 5, getY());
                this.setPosition(getX() - HERO_STEP - 5, getY());
                this.isHeroLookRight = false;
                this.isHeroLookLeft = true;
                textureHero = new Texture("characters/jumpingLeft.png");
                textureRegionHero = new TextureRegion(textureHero);
                spriteHero = new Sprite(textureRegionHero);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if(!needJump) {
                walkSheet = new Texture("characters/runningRight.png"); // #9

                isHeroRun(walkSheet);

                spriteHero.setPosition(getX() + HERO_STEP + 5, getY());
                this.setPosition(getX() + HERO_STEP + 5, getY());

                this.isHeroLookRight = true;
                this.isHeroLookLeft = false;
            }else{
                spriteHero.setPosition(getX() + HERO_STEP + 5, getY());
                this.setPosition(getX() + HERO_STEP + 5, getY());

                this.isHeroLookRight = true;
                this.isHeroLookLeft = false;

                textureHero = new Texture("characters/jumpingRight.png");
                textureRegionHero = new TextureRegion(textureHero);
                spriteHero = new Sprite(textureRegionHero);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if(!needJump) {
                if (firstPressed == true) {
                    walkSheet = new Texture("characters/runningRight.png"); // #9

                    isHeroRun(walkSheet);

                    spriteHero.setPosition(getX(), getY() - HERO_STEP);
                    this.setPosition(getX(), getY() - HERO_STEP);
                    this.firstPressed = false;
                    this.isHeroLookLeft = false;
                    this.isHeroLookRight = true;
                } else {
                    isHeroRun();

                    spriteHero.setPosition(getX(), getY() - HERO_STEP);
                    this.setPosition(getX(), getY() - HERO_STEP);
                }
            }else{
                spriteHero.setPosition(getX(), getY() - HERO_STEP);
                this.setPosition(getX(), getY() - HERO_STEP);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if(!needJump) {
                if (firstPressed == true) {
                    walkSheet = new Texture("characters/runningRight.png"); // #9

                    isHeroRun(walkSheet);

                    spriteHero.setPosition(getX(), getY() + HERO_STEP);
                    this.setPosition(getX(), getY() + HERO_STEP);

                    this.firstPressed = false;
                    this.isHeroLookLeft = false;
                    this.isHeroLookRight = true;

                } else {
                    isHeroRun();

                    spriteHero.setPosition(getX(), getY() + HERO_STEP);
                    this.setPosition(getX(), getY() + HERO_STEP);
                }
            }else{
                spriteHero.setPosition(getX(), getY() + HERO_STEP);
                this.setPosition(getX(), getY() + HERO_STEP);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            needJump = true;
        }

        float W = Gdx.graphics.getWidth();
        float H = Gdx.graphics.getHeight();

        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            textureHeroAttack = new Texture("characters/attackingRight.png"); // #9
            isHeroAttack(textureHeroAttack);
        }

        if(this.getY() <= -10){
            this.setPosition(this.getX(), -10);
            spriteHero.setPosition(spriteHero.getX(), -10);
        }

        if(this.getY() >= Gdx.graphics.getHeight() - H / 5){
            this.setPosition(this.getX(), Gdx.graphics.getHeight() - H / 5);
            spriteHero.setPosition(spriteHero.getX(), Gdx.graphics.getHeight() - H / 5);
        }

        if(this.getX() >= W - W / 7){
            this.setPosition(W - W / 7, this.getY());
            spriteHero.setPosition(W - W / 7, this.getY());
        }

        if(this.getX() <= -10){
            this.setPosition(-10, this.getY());
            spriteHero.setPosition(-10, this.getY());
        }



    }

    public void draw (Batch batch, float parentAlpha) {
        batch.draw(textureRegionHero, getX(), getY());
    }
}

