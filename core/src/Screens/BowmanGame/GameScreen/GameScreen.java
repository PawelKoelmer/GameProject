package Screens.BowmanGame.GameScreen;

import Screens.AbstractScreen;
import Screens.BowmanGame.Controller.PlayerController;
import Screens.BowmanGame.GameScreen.BackGround.StageDrawing;
import Screens.BowmanGame.Hero.Player;
import com.mygdx.game.Bowman;

public class GameScreen extends AbstractScreen {

    private PlayerController controller;
    private Player player;
    private StageDrawing background;

    public GameScreen(Bowman game) {
        super(game);
        init();
        game.setStarted(false);
    }
    private void init(){

        initPlayer();
        background = new StageDrawing(this,player);
        controller = new PlayerController(player,this,background);

    }
    private void initPlayer(){


        player = new Player();
        player.setPosition(20,0);
        stage.addActor(player);

    }

    @Override
    public void render(float delta){
        super.render(delta);
        controller.gameControl();
        background.draw();
    }

}
