package com.adapps.copterblaster.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.geom.Rectangle2D;

import sun.rmi.runtime.Log;


public class MenuState extends State {

    Texture background;
    Texture play;
    Sprite sprite;
    Rectangle2D bounds;

    float firstX;
    float firstY;
    float secondX;
    float secondY;


    public MenuState(GameStateManager gameStateManager){
        super(gameStateManager);

        background = new Texture("background2.png");
        play = new Texture("playButton.png");
        sprite = new Sprite(play);

        firstX=(float)(Gdx.graphics.getWidth()/2-play.getWidth()/2);
        firstY=(float)(Gdx.graphics.getHeight()/2-play.getHeight()/2);
        secondX=firstX+play.getWidth();
        secondY=firstY+(play.getHeight());
    }

    @Override
    public void handleInput() {

        if (Gdx.input.justTouched()){
            if (!( ((float)Gdx.input.getX() > firstX && (float)Gdx.input.getY() > firstY)
                  && ((float)Gdx.input.getX() < secondX &&  (float)Gdx.input.getX()< secondY))) {//touch the screen
                gameStateManager.set(new PlayState(gameStateManager)); //set the state to PlayState
                //dispose(); //dispose the MenuState
            }
       }
    }

    @Override
    public void update(float up) {
          handleInput();
    }

    @Override
    public void render(SpriteBatch sp) {
        sp.begin();
        sp.draw(background,0,0);
        sp.draw(play,Gdx.graphics.getWidth()/2-play.getWidth()/2,Gdx.graphics.getHeight()/2-play.getHeight()/2);
        sp.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        play.dispose();
    }
}
