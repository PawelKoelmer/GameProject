package Screens.BowmanGame.GameScreen.BackGround;

import Screens.BowmanGame.GameScreen.GameScreen;
import Screens.BowmanGame.Hero.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import javax.swing.text.PlainDocument;

public class StageDrawing {

    public float xBg1,xBg2;
    private Texture bgTexture1,bgTexture2;
    private GameScreen screen;
    private Player player;
    public StageDrawing(GameScreen screen, Player player){
        this.screen = screen;
        this.player = player;
        xBg1=0;
        xBg2=screen.camera.viewportWidth;

        bgTexture1 = new Texture("Forest.png");
        bgTexture2 = new Texture("Forest.png");
    }
    public void draw(){

        float dt = Gdx.graphics.getDeltaTime();

        screen.spriteBatch.begin();
        screen.spriteBatch.draw(bgTexture1,xBg1,0,screen.camera.viewportWidth,screen.camera.viewportHeight);
        screen.spriteBatch.draw(bgTexture2,xBg2,0,screen.camera.viewportWidth,screen.camera.viewportHeight);
        screen.spriteBatch.end();
        screen.spriteBatch.begin();

        if(player.getBoundingRectangle().x >= xBg1
                || player.velocityX > 0
                || player.getBoundingRectangle().getX() > xBg2) {
            screen.stage.act(dt);
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.velocityX = 0;
            player.setAnimation(screen.animWalk);
            screen.stage.act(dt);
        }
        screen.stage.draw();
        screen.spriteBatch.end();
    }
}
