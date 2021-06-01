package com.mygdx.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.Actors.ActorHero;


public class MainGameScreen extends BaseScreen implements ApplicationListener
{
    public MainGameScreen(MainGame game)
    {
        super(game);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        textureHero = new Texture("CharacterTilesSet-Right.png");
        spriteHero = new Sprite(textureHero);
        needJump = false;
        jumpDown = false;
        jumpUp = true;
        isUp=false;
        isDown=false;
        isRight = false;
        isLeft = false;
        isRightUp = false;
        isRightDown = false;
        isLeftUp = false;
        isLeftDown = false;
//        spriteHero.setPosition(w/2 - spriteHero.getWidth()/2, h/2 - spriteHero.getHeight()/2);

    }

    private SpriteBatch batch;
    private Stage stage;
    private ActorHero actorHero;
    private Texture textureHero;
    private Sprite spriteHero;
    private MoveToAction move;

    private Boolean needJump;
    private Boolean jumpUp;
    private Boolean jumpDown;

    private Boolean isUp;
    private Boolean isDown;
    private Boolean isRight;
    private Boolean isLeft;
    private Boolean isLeftUp;
    private Boolean isLeftDown;
    private Boolean isRightUp;
    private Boolean isRightDown;

    private int yCount = 0;

    @Override
    public void show() {
        stage = new Stage();
        actorHero = new ActorHero(textureHero);
        actorHero.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        actorHero.setSpriteHeroPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//        move = new MoveToAction();
//        move.setActor(actorHero);

        // Arrows
        Texture arrow_u_texture = new Texture("arrow_u.png");
        TextureRegion arrow_u_TextureRegion = new TextureRegion(arrow_u_texture);
        TextureRegionDrawable arrow_u_TexRegionDrawable = new TextureRegionDrawable(arrow_u_TextureRegion);
        ImageButton arrow_u_btn = new ImageButton(arrow_u_TexRegionDrawable);
        arrow_u_btn.setPosition(Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() - 350);

        Texture arrow_l_texture = new Texture("arrow_l.png");
        TextureRegion arrow_l_TextureRegion = new TextureRegion(arrow_l_texture);
        TextureRegionDrawable arrow_l_TexRegionDrawable = new TextureRegionDrawable(arrow_l_TextureRegion);
        ImageButton arrow_l_btn = new ImageButton(arrow_l_TexRegionDrawable);
        arrow_l_btn.setPosition(Gdx.graphics.getWidth() / 6 - 55, Gdx.graphics.getHeight() - 405);

        Texture arrow_r_texture = new Texture("arrow_r.png");
        TextureRegion arrow_r_TextureRegion = new TextureRegion(arrow_r_texture);
        TextureRegionDrawable arrow_r_TexRegionDrawable = new TextureRegionDrawable(arrow_r_TextureRegion);
        ImageButton arrow_r_btn = new ImageButton(arrow_r_TexRegionDrawable);
        arrow_r_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 405);

        Texture arrow_d_texture = new Texture(Gdx.files.internal("arrow_d.png"));
        TextureRegion arrow_d_TextureRegion = new TextureRegion(arrow_d_texture);
        TextureRegionDrawable arrow_d_TexRegionDrawable = new TextureRegionDrawable(arrow_d_TextureRegion);
        ImageButton arrow_d_btn = new ImageButton(arrow_d_TexRegionDrawable);
        arrow_d_btn.setPosition(Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() - 460);

        Texture arrow_ru_texture = new Texture(Gdx.files.internal("arrow_ru.png"));
        TextureRegion arrow_ru_TextureRegion = new TextureRegion(arrow_ru_texture);
        TextureRegionDrawable arrow_ru_TexRegionDrawable = new TextureRegionDrawable(arrow_ru_TextureRegion);
        ImageButton arrow_ru_btn = new ImageButton(arrow_ru_TexRegionDrawable);
        arrow_ru_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 350);

        Texture arrow_lu_texture = new Texture(Gdx.files.internal("arrow_lu.png"));
        TextureRegion arrow_lu_TextureRegion = new TextureRegion(arrow_lu_texture);
        TextureRegionDrawable arrow_lu_TexRegionDrawable = new TextureRegionDrawable(arrow_lu_TextureRegion);
        ImageButton arrow_lu_btn = new ImageButton(arrow_lu_TexRegionDrawable);
        arrow_lu_btn.setPosition(Gdx.graphics.getWidth() / 6 - 45, Gdx.graphics.getHeight() - 350);

        Texture arrow_rd_texture = new Texture(Gdx.files.internal("arrow_rd.png"));
        TextureRegion arrow_rd_TextureRegion = new TextureRegion(arrow_rd_texture);
        TextureRegionDrawable arrow_rd_TexRegionDrawable = new TextureRegionDrawable(arrow_rd_TextureRegion);
        ImageButton arrow_rd_btn = new ImageButton(arrow_rd_TexRegionDrawable);
        arrow_rd_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 450);

        Texture arrow_ld_texture = new Texture(Gdx.files.internal("arrow_ld.png"));
        TextureRegion arrow_ld_TextureRegion = new TextureRegion(arrow_ld_texture);
        TextureRegionDrawable arrow_ld_TexRegionDrawable = new TextureRegionDrawable(arrow_ld_TextureRegion);
        ImageButton arrow_ld_btn = new ImageButton(arrow_ld_TexRegionDrawable);
        arrow_ld_btn.setPosition(Gdx.graphics.getWidth() / 6 - 45, Gdx.graphics.getHeight() - 450);

        Texture jump_texture = new Texture(Gdx.files.internal("jump.png"));
        TextureRegion jump_TextureRegion = new TextureRegion(jump_texture);
        TextureRegionDrawable jump_TexRegionDrawable = new TextureRegionDrawable(jump_TextureRegion);
        ImageButton jump_btn = new ImageButton(jump_TexRegionDrawable);
        jump_btn.setPosition(Gdx.graphics.getWidth() - 145, Gdx.graphics.getHeight() - 405);

        // stage.addActor(arrows)
        stage.addActor(arrow_u_btn);
        stage.addActor(arrow_l_btn);
        stage.addActor(arrow_r_btn);
        stage.addActor(arrow_d_btn);
        stage.addActor(arrow_ru_btn);
        stage.addActor(arrow_lu_btn);
        stage.addActor(arrow_rd_btn);
        stage.addActor(arrow_ld_btn);
        stage.addActor(jump_btn);

        Gdx.input.setInputProcessor(stage);
        stage.addActor(actorHero);
//        actorHero.rotateBy(180);
//        actorHero.act(100);

        jump_btn.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent e, float x, float y){
               needJump = true;
           }
        });

        arrow_u_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                isUp=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isUp=false;
            }
        });
        arrow_d_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isDown=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isDown=false;
            }
        });
        arrow_r_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isRight=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isRight=false;
            }
        });
        arrow_l_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isLeft=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isLeft=false;
            }
        });
        arrow_lu_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isLeftUp=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isLeftUp=false;
            }
        });
        arrow_ru_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isRightUp=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isRightUp=false;
            }
        });
        arrow_ld_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isLeftDown=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isLeftDown=false;
            }
        });
        arrow_rd_btn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                isRightDown=true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                isRightDown=false;
            }
        });

    }

    @Override
    public void hide() {
        stage.dispose();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(needJump)
        {
            if(yCount == 0 && jumpUp){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
                yCount++;
            }


            if(yCount > 0 && yCount < 25 && jumpUp){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
                yCount++;
            }
            if(yCount >= 25  && yCount < 40 && jumpUp){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_2());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_2());
                yCount++;
            }
            if(yCount >= 40  && yCount < 53 && jumpUp){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_3());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_3());
                yCount++;
            }
            if(yCount >= 53  && yCount < 60 && jumpUp){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_4());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_4());
                yCount++;
            }


            if(yCount == 60 && jumpUp){
                jumpUp = false;
                jumpDown = true;
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
                yCount--;
            }



            if(yCount >= 53  && yCount < 61 && jumpDown){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
                yCount--;
            }
            if(yCount >= 40  && yCount < 53 && jumpDown){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_3());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_3());
                yCount--;
            }
            if(yCount >= 25  && yCount < 40 && jumpDown){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_2());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_2());
                yCount--;
            }
            if(yCount > 0 && yCount < 25 && jumpDown){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_1());
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_1());
                yCount--;
            }


            if(yCount == 0 && jumpDown){
                needJump = false;
                jumpUp = true;
                jumpDown = false;
            }
        }

        if(isUp)
        {
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getSTEP());
        }
        if(isDown)
        {
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getSTEP());
        }
        if(isRight)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Right.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP() + 5, actorHero.getY());
            actorHero.setPosition(actorHero.getX() + actorHero.getSTEP() + 5, actorHero.getY());
        }
        if(isLeft)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Left.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP() - 5, actorHero.getY());
            actorHero.setPosition(actorHero.getX() - actorHero.getSTEP() - 5, actorHero.getY());
        }
        if(isRightDown)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Right.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP() - 5, actorHero.getY() - actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX() + actorHero.getSTEP() - 5, actorHero.getY() - actorHero.getSTEP());
        }
        if(isLeftDown)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Left.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP() + 5, actorHero.getY() - actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX() - actorHero.getSTEP() + 5, actorHero.getY() - actorHero.getSTEP());
        }
        if(isRightUp)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Right.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP() - 5, actorHero.getY() + actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX() + actorHero.getSTEP() - 5, actorHero.getY() + actorHero.getSTEP());
        }
        if(isLeftUp)
        {
            actorHero.setTextureHero(new Texture("CharacterTilesSet-Left.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
            spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP() + 5, actorHero.getY() + actorHero.getSTEP());
            actorHero.setPosition(actorHero.getX() - actorHero.getSTEP() + 5, actorHero.getY() + actorHero.getSTEP());
        }
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void create()
    {}

    @Override
    public void render() {

    }

    @Override
    public void dispose()
    {
        batch.dispose();
    }

}