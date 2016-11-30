package com.adapps.copterblaster.Sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;

//This class is of no use until now. More Work will be done soon.
/**
 * Created by 1405006 on 11/30/2016.
 */

public class Fireballs {
    private static final int MOVEMENT = 200;
    private Vector3 position;//Vector3 holds x,y,z axes
    private Vector3 velocity;
    // public Rectangle copBounds;

    private TextureAtlas fire;

    public Fireballs(int x, int y) {
        position = new Vector3(x, y, 0); //no z axis
        velocity = new Vector3(0, 0, 0);
        fire = new TextureAtlas(Gdx.files.internal("fireball.atlas"));
    }
}
