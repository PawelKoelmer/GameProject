package Screens.BowmanGame.Hero;

import Screens.BowmanGame.AbstractActor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.Constans;


public class Player extends AbstractActor {

    public Player(){
        super();
        bounds = new Rectangle();
        flipedLeft = false;
        flipedRight = true;
        setWidth(Constans.PLAYER_WIDTH);
        setHeight(Constans.PLAYER_HEIGHT);
        velocityX=0;
        velocityY=0;
        movingAtlas = new TextureAtlas(Gdx.files.internal("HeroWalk.atlas"));
        animWalk = new Animation(1f/15f,movingAtlas.getRegions());
        standingAtlas = new TextureAtlas(Gdx.files.internal("HeroStand.atlas"));
        animStand = new Animation(1f/10f,standingAtlas.getRegions());
        jumpAtlas = new TextureAtlas(Gdx.files.internal("JumpHero.atlas"));
        animJump = new Animation(1f/10f,jumpAtlas.getRegions());
        setAnimationStanding();
    }




}
