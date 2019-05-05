package Screens.BowmanGame.GameScreen;

import Controler.GameKeys;
import Controler.Controler;
import Screens.BowmanGame.Objects.Background;
import Screens.BowmanGame.Objects.Enemy;
import Screens.BowmanGame.Objects.Ground;
import Screens.BowmanGame.Objects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Constants;
import utils.BodyUtils;
import utils.GameUtils;

public class GameStage extends Stage implements ContactListener {

    private World world;
    private Ground ground;
    private Player player;


    private Background background;
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    private Controler controler;
    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    private GameKeys gameKeys;

    public GameStage(){

        renderer = new Box2DDebugRenderer();
        setupCamera();
        initStage();

    }
    private void setupCamera() {
        camera = new OrthographicCamera(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }
    public void initStage(){

        world = GameUtils.createWorld();
        world.setContactListener(this);


        initBackground();
        setPlayer();
        setEnemy();
        setGround();
        setupControler();
        addActor(player);

    }
    public void setGround(){
        ground=new Ground(GameUtils.createGround(world));
        addActor(ground);
    }
    public void setPlayer(){
        player=new Player(GameUtils.createRunner(world),this,background);

    }
    public void setEnemy(){
        Enemy enemy = new Enemy(GameUtils.createEnemy(world));

        addActor(enemy);
    }
    public void initBackground(){
        background = new Background();
        addActor(background);
    }
    @Override
    public void act(float delta) {
        super.act(delta);

        Array<Body> bodies = new Array<Body>(world.getBodyCount());
        world.getBodies(bodies);
        for(Body body : bodies){
            update(body);
        }
        // Fixed timestep
        accumulator += delta;
        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
        //TODO: Implement interpolation
        if(gameKeys.isDown(gameKeys.RIGHT)){
            player.moveRight();
        }
        if(gameKeys.isDown((gameKeys.LEFT))){
            player.moveLeft();
        }
        if(gameKeys.isDown(gameKeys.JUMP)){
            player.jump();

        }
    }

    @Override
    public void draw() {
        super.draw();
//        renderer.render(world,camera.combined);
    }

    private void update(Body body){
        if(!BodyUtils.bodyInBounds(body)){
            if(BodyUtils.bodyIsEnemy(body)){
                setEnemy();
            }
            world.destroyBody(body);
        }
    }
    @Override
    public void beginContact(Contact contact) {
        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsGround(b))||
                (BodyUtils.bodyIsGround(a))&& BodyUtils.bodyIsPlayer(b)){
            player.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {

    }
    public void setupControler(){
        controler = new Controler(player);
        Gdx.input.setInputProcessor(controler);
        }


}
