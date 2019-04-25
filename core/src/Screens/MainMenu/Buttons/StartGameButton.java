package Screens.MainMenu.Buttons;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Bowman;
import com.mygdx.game.Constans;

public class StartGameButton extends Button {

    public StartGameButton(final IClickCallback callback){
        super(prepareStartGameButtonStyle());
        init(callback);
    }
    private void init(final IClickCallback callback){

        this.setX((Constans.APP_WIDTH -250)/2);
        this.setY(500);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    private static ButtonStyle prepareStartGameButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("MenuButtons.atlas"));
        Skin skin = new Skin(atlas);
        ButtonStyle buttonStyle = new ButtonStyle();
        buttonStyle.up = skin.getDrawable("startGame");
        buttonStyle.down = skin.getDrawable("startGame");

        return buttonStyle;
    }
}
