package Screens.BowmanGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public abstract class AbstractActor extends Actor {

    public TextureAtlas movingAtlas;
    public TextureAtlas standingAtlas;
    protected Animation animWalk;
    protected Animation animStand;
    protected boolean flipedLeft;
    protected boolean flipedRight;
    public float velocityX;
    public float velocityY;
    private float elapsedTime;
    private Animation<TextureRegion> anim;
    protected Animation animJump;
    public TextureAtlas jumpAtlas;
    public Rectangle bounds;

    public void draw(Batch batch, float parentAlpha){
        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a);
        if ( isVisible() ) {
            batch.draw(anim.getKeyFrame(elapsedTime) , getX(), getY(), getOriginX(),
                    getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }
    }
    public void setAnimationStanding(){
        this.anim = animStand;
        anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }
    public void setAnimationWalking(){
        this.anim = animWalk;
        anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }
    public void setAnimationJumping(){
        this.anim = animJump;
        anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }
    public Rectangle getBoundingRectangle(){
        bounds.set( getX(), getY(), getWidth(), getHeight());
        return bounds;
    }
    public void act(float dt){
        super.act( dt );
        elapsedTime += dt;

        moveBy( velocityX * dt, velocityY * dt );
    }
    public void flip(TextureAtlas tex){
        for(int i=0;i<5;i++){
            tex.getRegions().get(i).flip(true,false);
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
}
