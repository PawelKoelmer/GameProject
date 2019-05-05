package Screens.BowmanGame.Objects;

import Screens.BowmanGame.GameScreen.GameStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Constants;

import java.awt.*;

public class Background extends Actor {

    TextureRegion region;
    private Rectangle tex1Rect,tex2Rect;



    public Background(){
     region = new TextureRegion(new Texture(Gdx.files.internal(Constants.BACKGROUND_TEXTURE)));
     tex1Rect = new Rectangle(0,0,Constants.APP_WIDTH,Constants.APP_HEIGHT);
     tex2Rect = new Rectangle(Constants.APP_WIDTH,0,Constants.APP_WIDTH,Constants.APP_HEIGHT);

    }

    @Override
    public void draw(Batch batch,float parentAlpha){
       super.draw(batch,parentAlpha);
        batch.draw(region, tex1Rect.x, 0, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
        batch.draw(region, tex2Rect.x, 0, Constants.APP_WIDTH,
                Constants.APP_HEIGHT);
    }

    @Override
    public void act(float delta){
        if(leftBoundsReached(delta)){
            resetBounds();
        }
    }
   public void updateBounds(){
        tex1Rect.x -= 4;
        tex2Rect.x -= 4;
    }
    private boolean leftBoundsReached(float delta) {
        return (tex2Rect.x) <= 0;
    }
    private void resetBounds() {
        tex1Rect = tex2Rect;
        tex2Rect = new Rectangle(Constants.APP_WIDTH, 0, Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }

}
