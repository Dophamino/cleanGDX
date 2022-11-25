package com.mygdx.gdxtest.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LetterActor extends Actor {

    public enum LetterType{
        а,
        б
    }
    Texture texture;

    public LetterActor(float x, float y, LetterType letterType){
        setX(x);
        setY(y);
        switch (letterType){
            case а: {
                this.texture = new Texture(Gdx.files.internal("letter_A.png"));
                break; }
            case б: {
                this.texture = new Texture(Gdx.files.internal("letter_B.png"));
                break; }
        }
        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
        setScale(1f,1f);
        setRotation(0f);
        setOrigin(getWidth()/2,getHeight()/2);

        makeActions();

        this.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                makeActions();
            }


        } );
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
        batch.draw(new TextureRegion(texture), getX(),getY(),getOriginX(),getOriginY(),
                getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }

    public void makeActions(){
        SequenceAction scaleSequence = new SequenceAction();
        ScaleToAction scaleAction1 = new ScaleToAction();
        scaleAction1.setScale(1.5f);
        scaleAction1.setDuration(0.1f);
        ScaleToAction scaleAction2 = new ScaleToAction();
        scaleAction2.setScale(1);
        scaleAction2.setDuration(0.1f);
        scaleSequence.addAction(scaleAction1);
        scaleSequence.addAction(scaleAction2);

        SequenceAction rotateSequence = new SequenceAction();
        RotateByAction rotateAction1 = new RotateByAction();
        rotateAction1.setAmount(45);
        rotateAction1.setDuration(0.05f);
        RotateByAction rotateAction2 = new RotateByAction();
        rotateAction2.setAmount(-90);
        rotateAction2.setDuration(0.15f);
        RotateByAction rotateAction3 = new RotateByAction();
        rotateAction3.setAmount(45);
        rotateAction3.setDuration(0.05f);
        rotateSequence.addAction(rotateAction1);
        rotateSequence.addAction(rotateAction2);
        rotateSequence.addAction(rotateAction3);

        ParallelAction parallelAction = new ParallelAction();
        parallelAction.addAction(scaleSequence);
        parallelAction.addAction(rotateSequence);

        this.addAction(parallelAction);
    }
}
