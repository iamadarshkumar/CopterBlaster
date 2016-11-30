package com.adapps.copterblaster.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;


public class GameStateManager {

    public Stack<State> states;

    public GameStateManager(){
        states = new Stack<State>();

    }

    public void push(State state){
        states.push(state);
    }

    public void pop(){
        states.pop().dispose();
    }

    public void set(State state)
    {
        states.pop().dispose();
        states.push(state);

    }

    public void update(float up){
        states.peek().update(up);
    }

    public void render(SpriteBatch sp){
        states.peek().render(sp);
    }
}
