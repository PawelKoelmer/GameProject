package Screens.MainMenu.Buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.Bowman;
import com.mygdx.game.Constants;

public class QuitGameButton extends Button {
    public QuitGameButton(final IClickCallback callback){
        super(prepareQuitGameButtonStyle());
        init(callback);
    }
    private void init(final IClickCallback callback){


        this.setX((Constants.APP_WIDTH -250)/2);
        this.setY(400);

        this.addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y,
                                     int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
    private static Button.ButtonStyle prepareQuitGameButtonStyle() {
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("MenuButtons.atlas"));
        Skin skin = new Skin(atlas);
        Button.ButtonStyle buttonStyle = new Button.ButtonStyle();
        buttonStyle.up = skin.getDrawable("quit");
        buttonStyle.down = skin.getDrawable("quit");

        return buttonStyle;
    }


}
