package game;

import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The First Stage of the game
 */
public class Stage1 extends GameStage {
    public Stage1(Game game) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(game);

        getP1().setPosition(new Vec2(-10f, 0f));
        getP1().setGravityScale(0f);
        getP1().setAngleDegrees(90);

        getP2().setPosition(new Vec2(10f, 0f));
        getP2().setGravityScale(0f);
        getP2().setAngleDegrees(-90);

       getBump1().setPosition(new Vec2(0, 0));
       getBump1().addCollisionListener(new BumperContact(getBump1(), getP1(), getP2()));

       getSpeedup().setPosition(new Vec2(0,10));
       getSpeedup().setGravityScale(0);

       // Set it to continuous playback (looping)


    }


    /*Once the player has won 4 rounds, the next time their opponent makes contact with the blastzone the game
    progresses */


    @Override
    public boolean p1Wins() {
        if(getP1().getWinCount() == 4) {
            return true;
        }else
            return false;
    }

    @Override
    public boolean p2Wins() {
        if (getP2().getWinCount() == 4){
            return true;
        }else
            return false;
    }


    @Override
    public String getStageName() {
        return "Stage1";
    }
}
