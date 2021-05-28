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
//        spriteHero.setPosition(w/2 - spriteHero.getWidth()/2, h/2 - spriteHero.getHeight()/2);

    }

    private SpriteBatch batch;
    private Stage stage;
    private ActorHero actorHero;
    private Texture textureHero;
    private Sprite spriteHero;
    private MoveToAction move;

    private Texture arrow_u_texture;
    private TextureRegion arrow_u_TextureRegion;
    private TextureRegionDrawable arrow_u_TexRegionDrawable;
    private ImageButton arrow_u_btn;

    private Texture arrow_l_texture;
    private TextureRegion arrow_l_TextureRegion;
    private TextureRegionDrawable arrow_l_TexRegionDrawable;
    private ImageButton arrow_l_btn;

    private Texture arrow_r_texture;
    private TextureRegion arrow_r_TextureRegion;
    private TextureRegionDrawable arrow_r_TexRegionDrawable;
    private ImageButton arrow_r_btn;

    private Texture arrow_d_texture;
    private TextureRegion arrow_d_TextureRegion;
    private TextureRegionDrawable arrow_d_TexRegionDrawable;
    private ImageButton arrow_d_btn;

    private Texture arrow_ru_texture;
    private TextureRegion arrow_ru_TextureRegion;
    private TextureRegionDrawable arrow_ru_TexRegionDrawable;
    private ImageButton arrow_ru_btn;

    private Texture arrow_lu_texture;
    private TextureRegion arrow_lu_TextureRegion;
    private TextureRegionDrawable arrow_lu_TexRegionDrawable;
    private ImageButton arrow_lu_btn;

    private Texture arrow_rd_texture;
    private TextureRegion arrow_rd_TextureRegion;
    private TextureRegionDrawable arrow_rd_TexRegionDrawable;
    private ImageButton arrow_rd_btn;

    private Texture arrow_ld_texture;
    private TextureRegion arrow_ld_TextureRegion;
    private TextureRegionDrawable arrow_ld_TexRegionDrawable;
    private ImageButton arrow_ld_btn;



    @Override
    public void show() {
        stage = new Stage();
        actorHero = new ActorHero(textureHero);
        actorHero.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//        move = new MoveToAction();
//        move.setActor(actorHero);

        // Arrows
        arrow_u_texture = new Texture("arrow_u.png");
        arrow_u_TextureRegion = new TextureRegion(arrow_u_texture);
        arrow_u_TexRegionDrawable = new TextureRegionDrawable(arrow_u_TextureRegion);
        arrow_u_btn = new ImageButton(arrow_u_TexRegionDrawable);
        arrow_u_btn.setPosition(Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() - 350);

        arrow_l_texture = new Texture("arrow_l.png");
        arrow_l_TextureRegion = new TextureRegion(arrow_l_texture);
        arrow_l_TexRegionDrawable = new TextureRegionDrawable(arrow_l_TextureRegion);
        arrow_l_btn = new ImageButton(arrow_l_TexRegionDrawable);
        arrow_l_btn.setPosition(Gdx.graphics.getWidth() / 6 - 55, Gdx.graphics.getHeight() - 405);

        arrow_r_texture = new Texture("arrow_r.png");
        arrow_r_TextureRegion = new TextureRegion(arrow_r_texture);
        arrow_r_TexRegionDrawable = new TextureRegionDrawable(arrow_r_TextureRegion);
        arrow_r_btn = new ImageButton(arrow_r_TexRegionDrawable);
        arrow_r_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 405);

        arrow_d_texture = new Texture(Gdx.files.internal("arrow_d.png"));
        arrow_d_TextureRegion = new TextureRegion(arrow_d_texture);
        arrow_d_TexRegionDrawable = new TextureRegionDrawable(arrow_d_TextureRegion);
        arrow_d_btn = new ImageButton(arrow_d_TexRegionDrawable);
        arrow_d_btn.setPosition(Gdx.graphics.getWidth() / 6, Gdx.graphics.getHeight() - 460);

        arrow_ru_texture = new Texture(Gdx.files.internal("arrow_ru.png"));
        arrow_ru_TextureRegion = new TextureRegion(arrow_ru_texture);
        arrow_ru_TexRegionDrawable = new TextureRegionDrawable(arrow_ru_TextureRegion);
        arrow_ru_btn = new ImageButton(arrow_ru_TexRegionDrawable);
        arrow_ru_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 350);

        arrow_lu_texture = new Texture(Gdx.files.internal("arrow_lu.png"));
        arrow_lu_TextureRegion = new TextureRegion(arrow_lu_texture);
        arrow_lu_TexRegionDrawable = new TextureRegionDrawable(arrow_lu_TextureRegion);
        arrow_lu_btn = new ImageButton(arrow_lu_TexRegionDrawable);
        arrow_lu_btn.setPosition(Gdx.graphics.getWidth() / 6 - 45, Gdx.graphics.getHeight() - 350);

        arrow_rd_texture = new Texture(Gdx.files.internal("arrow_rd.png"));
        arrow_rd_TextureRegion = new TextureRegion(arrow_rd_texture);
        arrow_rd_TexRegionDrawable = new TextureRegionDrawable(arrow_rd_TextureRegion);
        arrow_rd_btn = new ImageButton(arrow_rd_TexRegionDrawable);
        arrow_rd_btn.setPosition(Gdx.graphics.getWidth() / 6 + 55, Gdx.graphics.getHeight() - 450);

        arrow_ld_texture = new Texture(Gdx.files.internal("arrow_ld.png"));
        arrow_ld_TextureRegion = new TextureRegion(arrow_ld_texture);
        arrow_ld_TexRegionDrawable = new TextureRegionDrawable(arrow_ld_TextureRegion);
        arrow_ld_btn = new ImageButton(arrow_ld_TexRegionDrawable);
        arrow_ld_btn.setPosition(Gdx.graphics.getWidth() / 6 - 45, Gdx.graphics.getHeight() - 450);
        // stage.addActor(arrows)
        stage.addActor(arrow_u_btn);
        stage.addActor(arrow_l_btn);
        stage.addActor(arrow_r_btn);
        stage.addActor(arrow_d_btn);
        stage.addActor(arrow_ru_btn);
        stage.addActor(arrow_lu_btn);
        stage.addActor(arrow_rd_btn);
        stage.addActor(arrow_ld_btn);

        Gdx.input.setInputProcessor(stage);
        stage.addActor(actorHero);
//        actorHero.rotateBy(180);
//        actorHero.act(100);

        arrow_u_btn.addListener(new ClickListener(){
           @Override
           public void clicked(InputEvent e, float x, float y){
                actorHero.setSpriteHero(new Sprite(textureHero));
                spriteHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.STEP);
                actorHero.setPosition(actorHero.getX(), actorHero.getY() + actorHero.STEP);
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