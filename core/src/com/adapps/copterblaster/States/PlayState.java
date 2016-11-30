package com.adapps.copterblaster.States;

import com.adapps.copterblaster.Sprites.Buildings;
import com.adapps.copterblaster.Sprites.Copter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.Random;



public class PlayState extends State {
    public int BUILD_SPACING = 999;
    public int BUILD_COUNT = 20;

    private SpriteBatch batch;
    private TextureAtlas fire;
    private Animation anime;
    public Random rand;
    private Copter cop;
    private Texture background;
    private float time=0;
    //private Buildings build;
    int randomPos;


    private Array<Buildings> buildings;

    public PlayState(GameStateManager gameStateManager) {

        super(gameStateManager);
        rand = new Random();
        randomPos = rand.nextInt(550);
        cop = new Copter(50,300);
        background=new Texture("background2.png");
        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        //build = new Buildings(100);
      //  System.out.println(randomPos);
        buildings = new Array<Buildings>();

        for(int i=1;i<=BUILD_COUNT;i++)
            buildings.add(new Buildings(i*(rand.nextInt(BUILD_SPACING))));

        batch = new SpriteBatch();
        fire = new TextureAtlas(Gdx.files.internal("fireball.atlas"));
        anime= new Animation(1/10f,fire.getRegions());
    }

    @Override
    protected void handleInput() {
            if(Gdx.input.isTouched()) //if Screen is touched
                cop.jump(); //the copter jumps
    }

    @Override
    public void update(float up) {
        handleInput();
        cop.update(up);
        for (int i = 0; i < buildings.size; i++) {
            Buildings b = buildings.get(i);

            if (cam.position.x - (cam.viewportWidth / 2) > b.getPosBuilding().x + b.getBuilding1().getWidth()) {
                b.reposition(b.getPosBuilding().x);
            }

            cam.position.x = cop.getPosition().x;
            cam.update();
        }
    }

    @Override
    public void render(SpriteBatch sp) {
        sp.setProjectionMatrix(cam.combined);
        sp.begin();
        sp.draw(background,cam.position.x-(cam.viewportWidth/2),0);
        sp.draw(cop.getHelicopter(),cop.getPosition().x-(cam.viewportWidth/2),cop.getPosition().y);
        //sp.draw(build.getBuilding1(),build.getPosBuilding().x,build.getPosBuilding().y);

        for(Buildings bld : buildings) {
            sp.draw(bld.getBuilding1(), bld.getPosBuilding().x, 0);
            sp.draw(bld.getBuilding2(), bld.getPosBuilding2().x, 0);
            sp.draw(bld.getBuilding3(), bld.getPosBuilding3().x, 0);
            sp.draw(bld.getHospital(), bld.getPosHospital().x, 0);
        }
//Uncomment to work on fireballs
     /*   batch.begin();
        time+=Gdx.graphics.getDeltaTime();
        batch.draw(anime.getKeyFrame(time,true),400,100);
        batch.end();
        */
        sp.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        cop.dispose();
        fire.dispose();
        for(Buildings bd: buildings)
            bd.dispose();
    }
}
