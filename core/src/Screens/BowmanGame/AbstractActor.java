package Screens.BowmanGame;

import box2D.UserData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Constants;

import javax.swing.plaf.nimbus.State;
import java.awt.*;


public abstract class AbstractActor extends Actor {



    protected Body body;
    protected Sprite sprite;
    protected UserData userData;
    protected Rectangle screenRectangle;
    protected boolean flipedLeft=false;
    protected boolean flipedRight=true;
    protected TextureAtlas walkingAtlas;
    protected TextureAtlas standingAtlas;
    protected TextureAtlas jumpingAtlas;
    protected Animation animWalk;
    protected Animation animStand;
    protected Animation jumpAnimation;
    protected float elapsedTime=0;
    protected Animation anim;

    public AbstractActor(Body body){
        sprite = new Sprite();

        this.body=body;
        this.userData = (UserData) body.getUserData();
        screenRectangle=new Rectangle();
    }

    public abstract UserData getUserData();
    public void draw(){}

    private void updateRectangle() {
        screenRectangle.x = transformToScreen(body.getPosition().x - userData.getWidth() );
        screenRectangle.y = transformToScreen(body.getPosition().y - userData.getHeight() );
        screenRectangle.width = transformToScreen(userData.getWidth());
        screenRectangle.height = transformToScreen(userData.getHeight());
    }
    protected float transformToScreen(float n) {
        return Constants.WORLD_TO_SCREEN * n;
    }
    @Override
    public void act(float delta) {
        super.act(delta);
        if (body.getUserData() != null) {
            updateRectangle();
        } else {
            // This means the world destroyed the body (enemy or runner went out of bounds)
            remove();
        }

    }
    public boolean isFlipedLeft() {
        return flipedLeft;
    }

    public void setFlipedLeft(boolean fliped) {
        this.flipedLeft = fliped;
    }
    public boolean isFlipedRight() {
        return flipedRight;
    }

    public void setFlipedRight(boolean flipedRight) {
        this.flipedRight = flipedRight;
    }
    public void flip(TextureAtlas tex){
        for(int i=0;i<5;i++){
            tex.getRegions().get(i).flip(true,false);
        }
    }
    public void setAnim(Animation anim) {
        this.anim = anim;
    }
    public Body getBody() {
        return body;
    }

}
