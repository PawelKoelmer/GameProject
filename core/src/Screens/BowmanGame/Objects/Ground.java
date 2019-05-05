package Screens.BowmanGame.Objects;

import Screens.BowmanGame.AbstractActor;
import box2D.GroundUserData;
import com.badlogic.gdx.physics.box2d.Body;

public class Ground extends AbstractActor {

    public Ground(Body body) {
        super(body);
    }

    @Override
    public GroundUserData getUserData() {
        return (GroundUserData) userData;
    }
}
