/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.*;

/**
 * Holds information to Player 2
 */
public class PlayerIcon2 extends Walker {
    //sets the shape of player2
    private static final Shape iconShape = new PolygonShape(-0.01f,-2.46f, 1.9f,0.06f, 1.9f,1.22f, 1.11f,2.26f, 0.05f,2.49f, -1.28f,2.18f, -1.87f,1.26f, -1.9f,0.03f);

    private int winCount;

    private float speed = 15;

    //sets the image used to represent player1
    private static final BodyImage image =
            new BodyImage("data/p2icon.png",4.7f);


    /**
     * Player 2's character
     * @param world
     */
    public PlayerIcon2(World world) {
        super(world, iconShape);
        addImage(image);
    }

    /**
     * Gets Player 2's Gravity Scale
     * @return
     */
    @Override
    //allows the players gravity scale to be set
    public float getGravityScale() {
        return super.getGravityScale();
    }

    //Adds 1 point each time player1 makes contact with the blastzone
    public void addScore() {
        winCount++;
    }

    /**
     * Gests the current rounds won by Player 2
     * @return
     */
    public int getWinCount() {
        return winCount;
    }

    /**
     * Sets Player 2's win count
     * @param winCount
     */
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    /**
     * Gets Player 2's speed
     * @return
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Sets Player 2's speed
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
