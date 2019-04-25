package Screens.BowmanGame.GameScreen;

import Screens.AbstractScreen;
import Screens.BowmanGame.Controller.PlayerController;
import Screens.BowmanGame.GameScreen.BackGround.StageDrawing;
import Screens.BowmanGame.Hero.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Bowman;

public class GameScreen extends AbstractScreen {

    private PlayerController controller;
    private Player player;
    private StageDrawing background;

    public TextureAtlas movingAtlas;
    public TextureAtlas standingAtlas;
    public TextureAtlas jumpAtlas;

    public Animation animWalk;
    public Animation animStand;
    public Animation animJump;

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

        movingAtlas = new TextureAtlas(Gdx.files.internal("HeroWalk.atlas"));
        animWalk = new Animation(1f/15f,movingAtlas.getRegions());
        standingAtlas = new TextureAtlas(Gdx.files.internal("HeroStand.atlas"));
        animStand = new Animation(1f/10f,standingAtlas.getRegions());
        jumpAtlas = new TextureAtlas(Gdx.files.internal("JumpHero.atlas"));
        animJump = new Animation(1f/10f,jumpAtlas.getRegions());
        player = new Player();
        player.setAnimation(animStand);
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
