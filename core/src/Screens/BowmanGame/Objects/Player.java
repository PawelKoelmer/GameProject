package Screens.BowmanGame.Objects;

import Screens.BowmanGame.AbstractActor;
import Screens.BowmanGame.GameScreen.GameStage;
import box2D.PlayerUserData;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Constants;


public class Player extends AbstractActor {


    private boolean jumping;
    private boolean fakeWalking;
    private boolean movingRight;
    private boolean movingLeft;

    private float velocityX;
    private GameStage stage;
    private Background background;

    public Player(Body body,GameStage stage,Background b){
        super(body);
        this.stage =stage;
        this.background = b;
        jumpingAtlas = new TextureAtlas("JumpHero.atlas");
        jumpAnimation = new Animation(1/5f,jumpingAtlas.getRegions());
        standingAtlas = new TextureAtlas("HeroStand.atlas");
        animStand = new Animation(1f/10f,standingAtlas.getRegions());
        walkingAtlas = new TextureAtlas("HeroWalk.atlas");
        animWalk = new Animation(1f/10f,walkingAtlas.getRegions());
        animStand.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        animWalk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        jumpAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        anim=animStand;
        velocityX = 0;
    }

    @Override
    public PlayerUserData getUserData() {
        return (PlayerUserData) userData;
    }

    public void jump(){
        setAnim(jumpAnimation);
        if(!jumping && !movingRight && !movingLeft){
            body.applyLinearImpulse(getUserData().getJummpImpulse(),body.getWorldCenter(),true);
            jumping=true;
        }
        if(!jumping && (movingRight||movingLeft)){
            movingRight=false;
            movingLeft=false;
            if(flipedRight){

                body.applyLinearImpulse(getUserData().getMoving_jump_Impulse(),body.getWorldCenter(),true);
                if(body.getPosition().x + screenRectangle.width*4 >= stage.getCamera().viewportWidth/2){
                    background.updateBounds();
                }
                System.out.println(body.getPosition().x);
            }
            else if(flipedLeft){

                body.applyLinearImpulse(getUserData().getMoving_jump_impulse_left(),body.getWorldCenter(),true);
                if(screenRectangle.x + screenRectangle.width*4 >= stage.getCamera().viewportWidth/2){
                    background.updateBounds();
                }
            }
            jumping=true;
        }
    }

    public void landed(){
        if(!movingLeft || !movingRight) {
            setAnim(animStand);
        }
        else setAnim(animWalk);
        jumping=false;
    }

    public void stoped(){
        movingLeft=false;
        movingRight=false;
        setAnim(animStand);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
       batch.draw(anim.getKeyFrame(elapsedTime), screenRectangle.x, screenRectangle.y, Constants.PLAYER_TEXTURE_DIMENSION, Constants.PLAYER_TEXTURE_DIMENSION);
    }

    public void act(float dt){
        super.act(dt);
        elapsedTime +=dt ;
        if((screenRectangle.x + screenRectangle.width*4 >= stage.getCamera().viewportWidth/2)&& movingRight){
            fakeWalking=true;
            background.updateBounds();
        }
    }

    public void moveLeft() {
        if(isFlipedLeft() == false){
            flip(walkingAtlas);
            flip(standingAtlas);
            flipedLeft = true;
            flipedRight=false;
        }
        if((screenRectangle.x -screenRectangle.width >0 && jumping==false) && !fakeWalking) {
            setAnim(animWalk);
            body.setLinearVelocity((Constants.PLAYER_VELOCITY *-1) * Gdx.graphics.getDeltaTime(), Constants.WORLD_GRAVITY.y * Gdx.graphics.getDeltaTime());
            movingLeft = true;
        }
    }

    public void moveRight() {
        if(isFlipedRight() == false){
            flip(walkingAtlas);
            flip(standingAtlas);
            flipedLeft = false;
            flipedRight=true;
        }
        setAnim(animWalk);
        if( jumping==false && !fakeWalking   ) {

            if(screenRectangle.x >=stage.getCamera().viewportWidth/2){
                body.setLinearVelocity((Constants.PLAYER_VELOCITY*Gdx.graphics.getDeltaTime())*-1,0);
            }
             if(screenRectangle.x<= stage.getCamera().viewportWidth/2){
                body.setLinearVelocity(Constants.PLAYER_VELOCITY* Gdx.graphics.getDeltaTime(), Constants.WORLD_GRAVITY.y * Gdx.graphics.getDeltaTime());
            }

            movingRight = true;
        }

    }


    public void setMovingRight(boolean moving) {
        this.movingRight = moving;
    }
    public void setMovingLeft(boolean moving) {
        this.movingLeft = moving;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public boolean getJumping(){
        return jumping;
    }
    public void setFakeWalking(boolean fw){
        this.fakeWalking=fw;
    }
}


