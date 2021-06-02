package com.mygdx.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Shadow extends Actor {
    private Texture shadowTexture;
    private TextureRegion shadowTextureRegion;
    private Sprite shadowSprite;
    private ActorHero target;

    public Shadow(ActorHero target) {
        this.shadowTexture = new Texture("shadow_test.png");
        this.shadowTextureRegion = new TextureRegion(shadowTexture);
        this.shadowSprite = new Sprite(shadowTextureRegion);
        this.target = target;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(!target.isNeedJump()){
            this.setPosition(target.getX(), target.getY() - 50);
        }


    }
}
