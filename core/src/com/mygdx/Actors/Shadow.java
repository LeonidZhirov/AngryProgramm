package com.mygdx.Actors;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.Screens.MainGameScreen;

public class Shadow extends Actor {
    private Texture shadowTexture;
    private TextureRegion shadowTextureRegion;
    private Sprite shadowSprite;
    private ActorHero target;

    public Shadow(ActorHero target, String path) {
        this.shadowTexture = new Texture(path);
        this.shadowTextureRegion = new TextureRegion(shadowTexture);
        this.shadowSprite = new Sprite(shadowTextureRegion);
        this.target = target;
    }

    public void setShadowTexture(Texture shadowTexture) {
        this.shadowTexture = shadowTexture;
    }

    public void setShadowTextureRegion(TextureRegion shadowTextureRegion) {
        this.shadowTextureRegion = shadowTextureRegion;
    }

    public void setShadowSprite(Sprite shadowSprite) {
        this.shadowSprite = shadowSprite;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(!target.isNeedJump()){
            if(!target.isNeedAttack2() && !target.isNeedAttack3()) {
                if (target.isHeroLookRight()) {
                    if(target.isRight()) {
                        this.setPosition(target.getX() + 22, target.getY() + 5);
                    }else{
                        this.setPosition(target.getX() + 16, target.getY() + 5);
                    }
                }
                if (target.isHeroLookLeft()) {
                    this.setPosition(target.getX() + 20, target.getY() + 5);
                }
            }
            else {
                if (target.isHeroLookRight()) {
                    this.setPosition(target.getX() + 22, target.getY() + 5);
                }
                if (target.isHeroLookLeft()) {
                    this.setPosition(target.getX() + 20, target.getY() + 5);
                }
            }
        }


    }

    public void draw (Batch batch, float parentAlpha) {
        batch.draw(shadowTextureRegion, getX(), getY());
    }
}
