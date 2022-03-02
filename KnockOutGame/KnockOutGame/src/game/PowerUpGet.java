/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Mar 2021
 */

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Collision listener for Power Up that makes the player faster when collected
 */
public class PowerUpGet implements CollisionListener {

    private PlayerIcon p1;
    private PlayerIcon2 p2;
    private PowerUp speedup;
    private SoundClip get = new SoundClip("data/speedup.wav");

    /**
     * Sets the collision for the Power Up
     * @param s The power up
     * @param player1 Player 1
     * @param player2 Player 2
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public PowerUpGet(PowerUp s,PlayerIcon player1,PlayerIcon2 player2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.speedup = s;
        this.p1=player1;
        this.p2=player2;
    }

    /**
     * Sets the player's speed
     * @param e
     */
    @Override
    /* when either player 1 or 2 make contact with player 1 their speed from their controller classes is doubled until
    they move on to the next stage */
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof PlayerIcon) {
            speedup.destroy();
            p1.setSpeed(30);
            get.play();
        }else if (e.getOtherBody() instanceof PlayerIcon2) {
            speedup.destroy();
            p2.setSpeed(30);
            get.play();
        }
    }
}