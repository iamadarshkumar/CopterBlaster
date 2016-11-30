package com.adapps.copterblaster.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 vector;
    public GameStateManager gameStateManager;


    public State(GameStateManager gameStateManager){
        this.gameStateManager = gameStateManager;
        cam = new OrthographicCamera();
        vector = new Vector3();


    }

    protected abstract void handleInput();
    public abstract void update(float up);
    public abstract void render(SpriteBatch sp);
    public abstract void dispose();
}
