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
        batch = new SpriteBatch();

        textureHero = new Texture("characters/standingLeft.png");
        spriteHero = new Sprite(textureHero);
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

    private ImageButton createBtn(float x, float y, String name){
        Texture arrow_texture = new Texture("buttons/"+name+".png");
        TextureRegion arrow_TextureRegion = new TextureRegion(arrow_texture);
        TextureRegionDrawable arrow_TexRegionDrawable = new TextureRegionDrawable(arrow_TextureRegion);
        ImageButton arrow_btn = new ImageButton(arrow_TexRegionDrawable);
        arrow_btn.setPosition(x,y);
        return arrow_btn;
    }

    float W = Gdx.graphics.getWidth();
    float H = Gdx.graphics.getHeight();
    private SpriteBatch batch;
    private Stage stage;
    private ActorHero actorHero;
    private Texture textureHero;
    private Sprite spriteHero;
    private MoveToAction move;


    private Boolean isUp;
    private Boolean isDown;
    private Boolean isRight;
    private Boolean isLeft;
    private Boolean isLeftUp;
    private Boolean isLeftDown;
    private Boolean isRightUp;
    private Boolean isRightDown;

    @Override
    public void show() {
        stage = new Stage();
        actorHero = new ActorHero(textureHero);
        actorHero.setPosition(W / 2, H / 2);
        actorHero.setSpriteHeroPosition(W / 2, H / 2);


//        move = new MoveToAction();
//        move.setActor(actorHero);

        // Arrows

        ImageButton arrow_u_btn = createBtn(W / 6, H - 350, "arrow_u");
        ImageButton arrow_d_btn = createBtn(W / 6, H - 460, "arrow_d");
        ImageButton arrow_l_btn = createBtn(W / 6 - 55, H - 405, "arrow_l");
        ImageButton arrow_r_btn = createBtn(W / 6 + 55, H - 405, "arrow_r");
        ImageButton arrow_ru_btn = createBtn(W / 6 + 55, H - 350, "arrow_ru");
        ImageButton arrow_rd_btn = createBtn(W / 6 + 55, H - 450, "arrow_rd");
        ImageButton arrow_lu_btn = createBtn(W / 6 - 45, H - 350, "arrow_lu");
        ImageButton arrow_ld_btn = createBtn(W / 6 - 45, H - 450, "arrow_ld");
        ImageButton jump_btn = createBtn(W - 145, H - 405, "jump");
        ImageButton attack_btn = createBtn(W - 85, H - 405, "attack");

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
        stage.addActor(attack_btn);

        Gdx.input.setInputProcessor(stage);
        stage.addActor(actorHero);
//        actorHero.rotateBy(180);
//        actorHero.act(100);

        jump_btn.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent e, float x, float y){
               actorHero.isHeroJump(true);
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
//        if(needJump) {
//            actorHero.isHeroJump();
//        }
//
//            if(yCount == 0 && jumpUp){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
//                yCount++;
//            }
//
//
//            if(yCount > 0 && yCount < 25 && jumpUp){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_1());
//                yCount++;
//            }
//            if(yCount >= 25  && yCount < 40 && jumpUp){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_2());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_2());
//                yCount++;
//            }
//            if(yCount >= 40  && yCount < 53 && jumpUp){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_3());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_3());
//                yCount++;
//            }
//            if(yCount >= 53  && yCount < 60 && jumpUp){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_4());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.getJUMP_STEP_4());
//                yCount++;
//            }
//
//
//            if(yCount == 60 && jumpUp){
//                jumpUp = false;
//                jumpDown = true;
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
//                yCount--;
//            }
//
//
//
//            if(yCount >= 53  && yCount < 61 && jumpDown){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_4());
//                yCount--;
//            }
//            if(yCount >= 40  && yCount < 53 && jumpDown){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_3());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_3());
//                yCount--;
//            }
//            if(yCount >= 25  && yCount < 40 && jumpDown){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_2());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_2());
//                yCount--;
//            }
//            if(yCount > 0 && yCount < 25 && jumpDown){
//                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_1());
//                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.getJUMP_STEP_1());
//                yCount--;
//            }
//
//
//            if(yCount == 0 && jumpDown){
//                needJump = false;
//                jumpUp = true;
//                jumpDown = false;
//            }


        if(isUp)
        {
            if (actorHero.isFirstPressed()) {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else {
                actorHero.isHeroRun();

                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.HERO_STEP);
            }
        }
        if(isDown)
        {
            if (actorHero.isFirstPressed()) {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else {
                actorHero.isHeroRun();
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX(), actorHero.getY() - actorHero.HERO_STEP);
            }
        }
        if(isRight)
        {
            Texture walkSheet = new Texture("characters/runningRight.png"); // #9
            actorHero.isHeroRun(walkSheet);
            actorHero.setSpriteHeroPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY());
            actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY());
            actorHero.setHeroLookRight(true);
            actorHero.setHeroLookLeft(false);
        }else if (isRight){
            actorHero.setSpriteHeroPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY());
            actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY());
            actorHero.setHeroLookRight(true);
            actorHero.setHeroLookLeft(false);
        }
        if(isLeft)
        {
            Texture walkSheet = new Texture("characters/runningLeft.png"); // #9
            actorHero.isHeroRun(walkSheet);
            spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY());
            actorHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY());
            actorHero.setHeroLookRight(false);
            actorHero.setHeroLookLeft(true);
        }
        if(isRightDown)
        {
            if (actorHero.isFirstPressed())
            {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else
            {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
            }
        }
        if(isLeftDown)
        {
            if (actorHero.isFirstPressed())
            {
                Texture walkSheet = new Texture("characters/runningLeft.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else
            {
                Texture walkSheet = new Texture("characters/runningLeft.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() - actorHero.HERO_STEP);
            }
        }
        if(isRightUp)
        {
            if (actorHero.isFirstPressed()) {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else {
                Texture walkSheet = new Texture("characters/runningRight.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() + actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
            }
        }
        if(isLeftUp)
        {
            if (actorHero.isFirstPressed()) {
                Texture walkSheet = new Texture("characters/runningLeft.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setFirstPressed(false);
                actorHero.setHeroLookLeft(false);
                actorHero.setHeroLookRight(true);
            }
            else {
                Texture walkSheet = new Texture("characters/runningLeft.png"); // #9
                actorHero.isHeroRun(walkSheet);
                spriteHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
                actorHero.setPosition(actorHero.getX() - actorHero.getSTEP(), actorHero.getY() + actorHero.HERO_STEP);
            }
        }

        if (!(isRight||isLeft||isUp||isDown||isRightDown||isRightUp||isLeftDown||isLeftUp)) {
            actorHero.setTextureHero(new Texture("characters/defaultRight.png"));
            actorHero.setSpriteHero(new Sprite(textureHero));
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



