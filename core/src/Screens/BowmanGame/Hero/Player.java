package Screens.BowmanGame.Hero;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Player extends Actor {

    private boolean flipedLeft = false;
    private boolean flipedRight= true;
    public Rectangle bounds;
    public Animation<TextureRegion> anim;
    public TextureRegion region;
    public boolean movingLeft;
    public float elapsedTime;
    public float velocityX;
    public float velocityY;
    private static final int W=120;
    private static final int H=120;

    public Player(){

        super();
        region = new TextureRegion();
        bounds = new Rectangle();
        velocityX=0;
        velocityY=0;


    }
    public void setAnimation(Animation a){
        setWidth( W );
        setHeight( H );
        this.anim = a;
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
    public void draw(Batch batch, float parentAlpha){
        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a);
        if ( isVisible() ) {
            batch.draw(anim.getKeyFrame(elapsedTime) , getX(), getY(), getOriginX(),
                    getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());

        }
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
