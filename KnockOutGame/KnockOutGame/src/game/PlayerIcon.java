/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

/**
 * Holds information on Player 1
 */
public class PlayerIcon extends Walker {
    //sets the shape of player1
    private static final Shape iconShape = new PolygonShape(-0.01f,-2.46f, 1.9f,0.06f, 1.9f,1.22f, 1.11f,2.26f, 0.05f,2.49f, -1.28f,2.18f, -1.87f,1.26f, -1.9f,0.03f);

    private int winCount = 0;

    private float speed = 15;

    //sets the image used to represent player1
    private static final BodyImage image =
            new BodyImage("data/p1icon.png",4.7f);

    /**
     * Player 1's character
     * @param world
     */
    public PlayerIcon(World world) {
        super(world, iconShape);
        addImage(image);
    }

    /**
     * Sets the gravity scale of Player 1
     * @return
     */
    @Override
    //allows the players gravity scale to be set
    public float getGravityScale() {
        return super.getGravityScale();
    }

    /**
     * Adds points to Player 1's win count when their opponent touches the blastzone
     */
    public void addScore(){
        winCount++;
    }

    /**
     * Gets Player 1's win count
     * @return
     */
    public int getWinCount() {
        return winCount;
    }

    /**
     * Sets Player 1's win count
     * @param winCount
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * Gets the speed of Player 1
     * @return
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of Player 1
     * @param speed1
     */
    public void setSpeed(float speed1) {
        this.speed = speed1;
    }

}