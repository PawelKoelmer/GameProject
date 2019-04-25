package Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Bowman;
import com.mygdx.game.Constans;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;

public abstract class AbstractScreen implements Screen {

    protected Bowman game;
    public Stage stage;
    public SpriteBatch spriteBatch;
    public OrthographicCamera camera;

    public AbstractScreen(Bowman game){
        this.game=game;
        createCamera();
        stage = new Stage(new StretchViewport(Constans.APP_WIDTH,Constans.APP_HEIGHT,camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    game.dispose();
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    private void createCamera(){
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Constans.APP_WIDTH,Constans.APP_HEIGHT);
        camera.update();
    }
}
