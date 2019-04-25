package Screens.BowmanGame.Controller;

import Screens.BowmanGame.GameScreen.BackGround.StageDrawing;
import Screens.BowmanGame.GameScreen.GameScreen;
import Screens.BowmanGame.Hero.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PlayerController {

    private Player player;
    private GameScreen screen;
    private StageDrawing drawing;

    public PlayerController(Player player, GameScreen screen,StageDrawing drawing){
        this.player = player;
        this.screen = screen;
        this.drawing = drawing;

    }

    public void gameControl(){
        player.velocityY =0;
        player.velocityX=0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                player.velocityX -= 200;
                player.setAnimationWalking();

                if(player.getBoundingRectangle().x <= 0){
                    player.velocityX=0;
                }
                if(player.isFlipedLeft() == false){
                player.setFlipedLeft(true);
                player.flip(player.jumpAtlas);
                player.flip(player.movingAtlas);
                player.flip(player.standingAtlas);
                player.setFlipedRight(false);
            }
        }
        //Ustalenie animacji i przesunięcia oraz kierunku patrzenia postaci
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.velocityX += 200;
            player.setAnimationWalking();
            if(player.isFlipedRight() == false){
                player.setFlipedRight(true);
                player.flip(player.jumpAtlas);
                player.flip(player.movingAtlas);
                player.flip(player.standingAtlas);
                player.setFlipedLeft(false);
            }
            //Przewijanie tła - zapętlenie dwóch textur które przesuwają się w określonym punkcie
            if(player.getBoundingRectangle().x+player.getBoundingRectangle().width > screen.camera.viewportWidth/2){
                drawing.xBg1 = drawing.xBg1 - player.velocityX/40;
                drawing.xBg2 = drawing.xBg2 - player.velocityX/40;
                player.velocityX=0;
                if(drawing.xBg1<screen.camera.viewportWidth * -1){
                    drawing.xBg1=screen.camera.viewportWidth-5;
                }
                if(drawing.xBg2<screen.camera.viewportWidth * -1){
                    drawing.xBg2=screen.camera.viewportWidth-5;
                }
            }
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            player.velocityY +=100;
            player.setAnimationJumping();
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.CONTROL_LEFT)){
            System.out.println("Kill'em All");
        }
        else {
            player.setAnimationStanding();
        }


    }
}
