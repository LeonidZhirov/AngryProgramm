package com.mygdx.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
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



    @Override
    public void show() {
        stage = new Stage();
        actorHero = new ActorHero(textureHero);
        actorHero.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//        move = new MoveToAction();
//        move.setActor(actorHero);
        stage.addActor(actorHero);
//        actorHero.rotateBy(180);
//        actorHero.act(100);
    }

    @Override
    public void hide() {
        stage.dispose();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
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