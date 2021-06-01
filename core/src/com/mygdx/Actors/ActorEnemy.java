package com.mygdx.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorEnemy extends Actor
{
    private Texture textureEnemy;
    private TextureRegion textureRegionEnemy;
    private Sprite spriteEnemy;
    private boolean alive;
    private ActorHero actorHero;
    private final float STEP = 5f;

    public ActorEnemy(ActorHero actorHeroTarget) {
        textureEnemy = new Texture("characters/standingLeft.png");
        textureRegionEnemy = new TextureRegion(textureEnemy);
        this.alive=true;
        actorHero = actorHeroTarget;
        spriteEnemy = new Sprite(textureRegionEnemy);
        setSize(spriteEnemy.getRegionWidth(), spriteEnemy.getRegionHeight());
    }

    public void act(float delta)
    {
        super.act(delta);
        while (this.getX() != actorHero.getX())
        {
            if (this.getX() < actorHero.getX()) {
                this.setPosition(this.getX() + 1f, this.getY());
                spriteEnemy.setPosition(this.getX() + 1f, this.getY());
            }

            if (this.getX() > actorHero.getX()) {
                this.setPosition(this.getX() - 1f, this.getY());
                spriteEnemy.setPosition(this.getX() - 1f, this.getY());
            }
        }

        while (this.getY() != actorHero.getY())
        {
            if (this.getY() < actorHero.getY()) {
                this.setPosition(this.getX(), this.getY() + 1f);
                spriteEnemy.setPosition(this.getX(), this.getY() + 1f);
            }

            if (this.getX() > actorHero.getX()) {
                this.setPosition(this.getX(), this.getY() - 1f);
                spriteEnemy.setPosition(this.getX(), this.getY() - 1f);
            }
        }
    }

    public void draw(Batch batch, float parentAlpha) { batch.draw(textureRegionEnemy, getX(), getY()); }
}