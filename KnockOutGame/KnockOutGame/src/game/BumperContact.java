/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Gives collision to bumpers allowing them to rebound players when they make contact
 */
public class BumperContact implements CollisionListener {

    private PlayerIcon p1;
    private PlayerIcon2 p2;
    private Bumper bump1;
    private SoundClip rebound = new SoundClip("data/bump.wav");

    /**
     * List of bodies that can interact with bumpers
     * @param b The bumper that the players are interacting with
     * @param player1 Player 1's character
     * @param player2 Player 2's character
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public BumperContact(Bumper b,PlayerIcon player1,PlayerIcon2 player2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.bump1 = b;
        this.p1=player1;
        this.p2=player2;
    }


    /**
     * Causes the player to rebound in the opposite direction that they are facing when they make contact with a bumper
     * @param e A collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof PlayerIcon) {
            p1.setLinearVelocity(new Vec2(Math.round(30f*(-Math.sin((Math.round(p1.getAngle()))))),Math.round(15f*(Math.cos((Math.round(p1.getAngle())))))));
            rebound.play();
        }else if (e.getOtherBody() instanceof PlayerIcon2) {
            p2.setLinearVelocity(new Vec2(Math.round(30f*(-Math.sin((Math.round(p2.getAngle()))))),Math.round(15f*(Math.cos((Math.round(p2.getAngle())))))));
            rebound.play();
        }
    }
}