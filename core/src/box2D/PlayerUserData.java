package box2D;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Constants;
import enums.UserDataType;

public class PlayerUserData extends UserData {
    private Vector2 jummpImpulse;
    private Vector2 moving_jump_Impulse;
    private Vector2 moving_jump_impulse_left;

    public PlayerUserData(float width, float height){
        super(width,height);
        jummpImpulse = Constants.JUMP;
        userDataType = UserDataType.PLAYER;
        moving_jump_Impulse = Constants.WALK_AND_JUMP;
        moving_jump_impulse_left= Constants.WALK_AND_JUMP_LEFT;
        userDataType = UserDataType.PLAYER;
    }
    public Vector2 getJummpImpulse() {
        return jummpImpulse;
    }
    public void setJummpImpulse(Vector2 jummpImpulse) {
        this.jummpImpulse = jummpImpulse;
    }

    public Vector2 getMoving_jump_impulse_left() {
        return moving_jump_impulse_left;
    }
    public Vector2 getMoving_jump_Impulse() {
        return moving_jump_Impulse;
    }

}
