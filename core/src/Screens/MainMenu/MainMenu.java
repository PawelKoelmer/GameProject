package Screens.MainMenu;

import Screens.AbstractScreen;
import Screens.MainMenu.Buttons.IClickCallback;
import Screens.MainMenu.Buttons.QuitGameButton;
import Screens.MainMenu.Buttons.StartGameButton;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Bowman;

public class MainMenu extends AbstractScreen {

   private Texture bgTexture;
   private StartGameButton startGameButton;
   private QuitGameButton quitGameButton;

    public MainMenu(Bowman game) {
        super(game);
        init();
        initStartGameButton();
        initQuitGameButton();
    }
    private void initStartGameButton() {
        startGameButton = new StartGameButton(new IClickCallback() {
            @Override
            public void onClick() {
            game.setStarted(true);
            }
        });

        stage.addActor(startGameButton);
    }
    private void initQuitGameButton() {
         quitGameButton = new QuitGameButton(new IClickCallback() {
            @Override
            public void onClick() {
                Gdx.app.exit();
            }
        });

        stage.addActor(quitGameButton);
    }

    private void init(){
        bgTexture = new Texture("Menu.bmp");
    }
    @Override
    public void render(float delta){
        super.render(delta);
        update();
        spriteBatch.begin();
        spriteBatch.draw(bgTexture,0,0);
        spriteBatch.end();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
    private void update() {

        stage.act();
    }
}
