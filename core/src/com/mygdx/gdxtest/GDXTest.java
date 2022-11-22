package com.mygdx.gdxtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.gdxtest.actors.FirstActor;

public class GDXTest extends ApplicationAdapter implements InputProcessor {
	Stage stage;
	OrthographicCamera camera;
	FillViewport viewport;

	FirstActor[] actors = new FirstActor[10];

	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new FillViewport(500,500);
		stage = new Stage();
		for (int i=0; i<actors.length; i++){
			for (int j=0; j<10; j++){
				actors[i]=new FirstActor(i*50,j*50);
				stage.addActor(actors[i]);
			}
		}
		stage.setViewport(viewport);
		stage.getViewport().getCamera().position.set(stage.getViewport().getWorldWidth()/2,
				stage.getViewport().getWorldHeight()/2,
				0);
		System.out.println("WIDTH: " + stage.getViewport().getScreenWidth());
		System.out.println("HEIGHT: " + stage.getViewport().getScreenHeight());

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1,1,1,1);
		stage.act();
		stage.draw();
		camera.update();
	}
	
	@Override
	public void dispose () {
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, false);
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		float x = Gdx.input.getDeltaX();
		float y = Gdx.input.getDeltaY();

		stage.getViewport().getCamera().translate(-x/3,y/3,0);

		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
