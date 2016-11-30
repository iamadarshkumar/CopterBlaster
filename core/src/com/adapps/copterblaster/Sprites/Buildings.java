package com.adapps.copterblaster.Sprites;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;
public class Buildings {

    public static final int BUILD_WIDTH = 30;

    private Texture building1;
    private Texture building2;
    private Texture building3;
    private Texture hospital;

    private Vector2 posBuilding,posBuilding2,posBuilding3,posHospital;
    public int FLUCTUATION =400;
    private Random rand;


    public Buildings(float x){
        building1 = new Texture("building1.png");
        building2 = new Texture("building2.png");
        building3 = new Texture("building3.png");
        hospital = new Texture("hospital.png");

        rand = new Random();
        posBuilding = new Vector2(x,0);
        posBuilding2 = new Vector2(x+rand.nextInt(FLUCTUATION),0);
        posBuilding3 = new Vector2(x+2*rand.nextInt(FLUCTUATION),0);
        posHospital = new Vector2(x+10*rand.nextInt(FLUCTUATION),0);

    }

    public Vector2 getPosBuilding() {
        return posBuilding;
    }

    public Vector2 getPosBuilding2() {
        return posBuilding2;
    }

    public Vector2 getPosBuilding3() {
        return posBuilding3;
    }

    public Vector2 getPosHospital() {
        return posHospital;
    }

    public Texture getBuilding1() {
        return building1;
    }

    public Texture getBuilding2() {
        return building2;
    }

    public Texture getBuilding3() {
        return building3;
    }

    public Texture getHospital() {
        return hospital;
    }

    public void reposition(float x){
        posBuilding.set(rand.nextInt(FLUCTUATION),0);

    }

    public void dispose()
    {
        building1.dispose();
        building2.dispose();
        building3.dispose();
        hospital.dispose();
    }

}
