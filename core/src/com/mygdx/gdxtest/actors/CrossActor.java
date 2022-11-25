package com.mygdx.gdxtest.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CrossActor extends Actor {
    Texture texture;
    BitmapFont font = new BitmapFont();

    public CrossActor(float x, float y){
        setX(x);
        setY(y);
        this.texture = new Texture(Gdx.files.internal("cross.png"));
        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
        setScale(1f,1f);
        setRotation(0f);
        setOrigin(getWidth()/2,getHeight()/2);
    }

    @Override
    public void draw (Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
        batch.draw(new TextureRegion(texture), getX(),getY(),getOriginX(),getOriginY(),
         getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());

        font.setColor(0,0,0,1);
        font.getData().setScale((float) 0.5*getScaleX());
        font.draw(batch, String.valueOf((int) getX()),
                getX()+getOriginX(),getY()+getOriginY()-3);
        font.draw(batch, String.valueOf((int) getY()),
                getX()+getOriginX(),getY()+getOriginY()+9);
    }
}
