package com.adapps.copterblaster.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


public class Copter {

    private static final int GRAVITY = -10;
    private static final int MOVEMENT = 200;
    private Vector3 position;//Vector3 holds x,y,z axes
    private Vector3 velocity;
   // public Rectangle copBounds;

    private Texture helicopter;

    public Copter(int x,int y){
        position = new Vector3(x,y,0); //no z axis
        velocity = new Vector3(0,0,0);
        helicopter = new Texture("copter.png");
    }

    public void update(float dt){
        velocity.add(0,GRAVITY,0); //add gravity to y axis
        velocity.scl(dt); //multiply delta time
        position.add(MOVEMENT *dt ,velocity.y,0);

        velocity.scl(1/dt); //Reverse the delta time multiplication
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getHelicopter() {
        return helicopter;
    }

    public void jump(){
        velocity.y=250;
    }


    public void dispose()
    {
        helicopter.dispose();
    }

}
