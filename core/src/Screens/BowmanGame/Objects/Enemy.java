package Screens.BowmanGame.Objects;

import Screens.BowmanGame.AbstractActor;
import box2D.EnemyUserData;
import box2D.UserData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Constants;

public class Enemy extends AbstractActor {

    private TextureAtlas enemyStandAtlas;
    private Animation animation;
    private Animation animationEnemyStand;


    public Enemy(Body body) {
        super(body);

        enemyStandAtlas= new TextureAtlas("EnemyGoblin.atlas");
        flip(enemyStandAtlas);
        animationEnemyStand = new Animation(1/2f,enemyStandAtlas.getRegions());
        animation=animationEnemyStand;
    }

    @Override
    public EnemyUserData getUserData(){
        return (EnemyUserData) userData;
    }

    @Override
    public void act(float delta){
        super.act(delta);
        elapsedTime +=delta ;
        body.setLinearVelocity(getUserData().getLinearVelocity());
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(animation.getKeyFrame(elapsedTime), screenRectangle.x, screenRectangle.y, Constants.ENEMY_TEXTURE_DIMENSION, Constants.ENEMY_TEXTURE_DIMENSION);
    }
}
