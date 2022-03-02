/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Mar 2021
 */

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Creates a collectible power up for the players that moves on its own
 */
public class PowerUp extends DynamicBody implements StepListener{
    //sets the shape of the power up to a circle
    private static final Shape iconShape = new CircleShape(1.2f);

    //sets the image used to represent the power up
    private static final BodyImage image =
            new BodyImage("data/powerup.png", 2.5f);

    private enum State {
        GO_LEFT, GO_RIGHT
    }

    private GameStage stage;

    private State state;

    /**
     * Image for the Power Up
     * @param stage Current stage being played on
     */
    public PowerUp(GameStage stage) {
        super(stage, iconShape);
        addImage(image);
        this.stage = stage;
        state = State.GO_LEFT;
        getWorld().addStepListener(this);
    }

    /**
     * Sets the Gravity scale of the object
     * @return
     */
    @Override
    //allows the power ups gravity scale to be set
    public float getGravityScale() {
        return super.getGravityScale();
    }


    /**
     * Tells the object to move by itself when it as reached a certain position in the world
     * @param stepEvent Event that causes the object to change direction
     */
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x >= 20) {
            if (state != State.GO_LEFT){
            state = State.GO_LEFT;}
        } else if (getPosition().x <= -20){
            if (state != State.GO_RIGHT){
            state = State.GO_RIGHT;}
        }
        refreshPowerUp();
    }

    public void postStep (StepEvent stepEvent){

    }

    /**
     * Sets the direction that the Power Up icon goes in once it has travelled fare enough across the screen
     */
    private void refreshPowerUp() {
        switch (state) {
            case GO_LEFT:
                setLinearVelocity(new Vec2(-4,0));
                break;
            case GO_RIGHT:
                setLinearVelocity(new Vec2(4,0));
                break;
            default:

        }
    }
}

