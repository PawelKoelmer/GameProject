package Controler;

import Screens.BowmanGame.Objects.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class Controler extends InputAdapter {

    private Player player;
    public Controler(Player p){
        this.player = p;
    }

    public boolean keyDown(int k){
        if(k == Input.Keys.LEFT){
            GameKeys.setKey(GameKeys.LEFT,true);
        }
        if(k == Input.Keys.RIGHT){
            GameKeys.setKey(GameKeys.RIGHT,true);
        }
        if(k == Input.Keys.SPACE){
            GameKeys.setKey(GameKeys.JUMP,true);
        }
        if(k == Input.Keys.CONTROL_LEFT){
            GameKeys.setKey(GameKeys.SHOOT,true);
        }
        return true;
    }

    public boolean keyUp(int k) {
        if(k == Input.Keys.LEFT){
            GameKeys.setKey(GameKeys.LEFT,false);
            player.stoped();
            player.setFakeWalking(false);
        }
        if(k == Input.Keys.RIGHT){
            GameKeys.setKey(GameKeys.RIGHT,false);
            player.setFakeWalking(false);
           if(player.getJumping()==false){ player.stoped();
           }
        }
        if(k == Input.Keys.SPACE){
            GameKeys.setKey(GameKeys.JUMP,false);
        }
        if(k == Input.Keys.CONTROL_LEFT){
            GameKeys.setKey(GameKeys.SHOOT,false);
        }
        return true;
    }
}
