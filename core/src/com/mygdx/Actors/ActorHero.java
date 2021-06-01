package com.mygdx.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import sun.util.calendar.JulianCalendar;


public class ActorHero extends Actor {

    private Texture textureHero;
    private boolean alive;
    private boolean isGrounded = true;
    private Sprite spriteHero;
    //MoveByAction move = new MoveByAction();
    private final float STEP = 10f;

    private final float JUMP_STEP_1 = 8f;
    private final float JUMP_STEP_2 = 6f;
    private final float JUMP_STEP_3 = 3f;
    private final float JUMP_STEP_4 = 1f;


    public boolean isAlive() {
        return true;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isGrounded() {
        return isGrounded;
    }

    public void setGrounded(boolean grounded) {
        isGrounded = grounded;
    }

    public float getSTEP() {
        return STEP;
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

    public void setTextureHero(Texture textureHero) {
        this.textureHero = textureHero;
    }

    public void setSpriteHero(Sprite spriteHero) {
        this.spriteHero = spriteHero;
    }

    public void setSpriteHeroPosition(float x, float y){ this.spriteHero.setPosition(x, y); }

    public ActorHero(Texture textureHero){
        this.textureHero=textureHero;
        this.alive=true;
        spriteHero = new Sprite(textureHero);
        setSize(spriteHero.getRegionWidth(), spriteHero.getRegionHeight());
    }


    public void act (float delta)
    {
        super.act(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            textureHero = new Texture("CharacterTilesSet-Left.png");
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX() - STEP - 5, getY());
            this.setPosition(getX() - STEP - 5, getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            textureHero = new Texture("CharacterTilesSet-Right.png");
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX() + STEP + 5, getY());
            this.setPosition(getX() + STEP + 5, getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX(), getY() - STEP);
            this.setPosition(getX(), getY() - STEP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX(), getY() + STEP);
            this.setPosition(getX(), getY() + STEP);
        }

    }

    public void draw (Batch batch, float parentAlpha){
        batch.draw(textureHero, getX(), getY());
    }
}