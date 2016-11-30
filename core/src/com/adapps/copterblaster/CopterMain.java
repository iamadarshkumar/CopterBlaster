package com.adapps.copterblaster;

import com.adapps.copterblaster.States.GameStateManager;
import com.adapps.copterblaster.States.MenuState;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CopterMain extends ApplicationAdapter {
	GameStateManager gameStateManager;
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        gameStateManager=new GameStateManager() ;
        img = new Texture("badlogic.jpg");
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gameStateManager.push(new MenuState(gameStateManager));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameStateManager.update(Gdx.graphics.getDeltaTime());
        gameStateManager.render(batch);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}
}
