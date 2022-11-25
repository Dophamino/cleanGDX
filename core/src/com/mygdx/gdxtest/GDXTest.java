package com.mygdx.gdxtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.gdxtest.actors.CrossActor;
import com.mygdx.gdxtest.actors.LetterActor;
import com.mygdx.gdxtest.inputProcessors.BasicInput;
import com.mygdx.gdxtest.inputProcessors.GestureInput;

public class GDXTest extends ApplicationAdapter
		{
	Stage stage;
	OrthographicCamera camera;
	ExtendViewport viewport;
	CrossActor[] actors = new CrossActor[10];
	LetterActor actorA;
	LetterActor actorB;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		stage = new Stage();
		viewport = new ExtendViewport(250,250,camera);
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		stage.setViewport(viewport);

		camera.position.x = camera.viewportWidth/2;
		camera.position.y = camera.viewportHeight/2;

		for (int i=0; i<actors.length; i++){
			for (int j=0; j<10; j++){
				actors[i]=new CrossActor(i*50,j*50);
				stage.addActor(actors[i]);
			}
		}

		actorA = new LetterActor(25,25, LetterActor.LetterType.а);
		actorB = new LetterActor(125,25, LetterActor.LetterType.б);
		stage.addActor(actorA);
		stage.addActor(actorB);

		BasicInput basicInput = new BasicInput(camera);
		GestureInput gestureInput = new GestureInput(camera);
		GestureDetector gestureDetector = new GestureDetector(gestureInput);
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(basicInput);
		inputMultiplexer.addProcessor(gestureDetector);
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
	}

	@Override
	public void render () {
		camera.update();
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1,1,1,1);

		stage.act();
		stage.draw();
	}

	@Override
	public void dispose () {
		stage.dispose();
	}

	@Override
	public void resize(int width, int height) {
		System.out.println(camera.viewportWidth);
		viewport.update(width, height);
		camera.position.x = camera.viewportWidth/2;
		camera.position.y = camera.viewportHeight/2;
	}
}
