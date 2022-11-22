package com.mygdx.gdxtest.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class FirstActor extends Actor {
    Texture texture;
    BitmapFont font = new BitmapFont();

    public FirstActor(float x, float y){
        setX(x);
        setY(y);
        this.texture = new Texture(Gdx.files.internal("cross.png"));
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
        batch.draw(texture,
                getX()-texture.getWidth()/2,
                getY()-texture.getHeight()/2);
        font.setColor(0,0,0,1);
        font.getData().setScale(0.5f);
        font.draw(batch, String.valueOf((int) getX()),getX(),getY()-3);
        font.draw(batch, String.valueOf((int) getY()),getX(),getY()+9);
    }
}
