/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Collision listener that allows players to gain points when their opponent makes contact with it
 */
public class Blastzone implements CollisionListener {

    private StaticBody wall1;
    private StaticBody wall2;
    private StaticBody ceiling;
    private StaticBody floor;

    private PlayerIcon p1;
    private PlayerIcon2 p2;

    private SoundClip boom = new SoundClip("data/deathboom.wav");

    /**
     *
     * Resets the game state when the player makes contact with the body.
     * <p>
     * When the player makes contact with a body, the games state is reset and a point is given to their opponent
     *
     * @param  l Left wall of the blastzone
     * @param  r Right wall of the blastzone
     * @param  d Bottom wall of the blastzone
     * @param  u Top wall of the blastzone
     * @param  player1 Player 1's body
     * @param  player2 Player 2's body
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public Blastzone (StaticBody l, StaticBody r, StaticBody d, StaticBody u,PlayerIcon player1,PlayerIcon2 player2) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.wall1 = l;
        this.wall2 = r;
        this.ceiling = u;
        this.floor = d;
        this.p1 = player1;
        this.p2 = player2;
    }

    /**
     * Sets the scores and resets the players positions in the stage when a the player makes contact with the blastzone
     * @param e A collision event
     */
    @Override
    public void collide(CollisionEvent e) {
        if(e.getOtherBody() instanceof PlayerIcon){
            p1.setPosition(new Vec2(-10,0));
            p2.setPosition(new Vec2(10,0));
            p1.setLinearVelocity(new Vec2(0,0));
            p2.setLinearVelocity(new Vec2(0,0));
            p1.setAngleDegrees(90);
            p2.setAngleDegrees(-90);
            p2.addScore();
            boom.play();
        }else if(e.getOtherBody() instanceof PlayerIcon2){
            p1.setPosition(new Vec2(-10,0));
            p2.setPosition(new Vec2(10,0));
            p1.setLinearVelocity(new Vec2(0,0));
            p2.setLinearVelocity(new Vec2(0,0));
            p1.setAngleDegrees(90);
            p2.setAngleDegrees(-90);
            p1.addScore();
            boom.play();
        }

    }
}
