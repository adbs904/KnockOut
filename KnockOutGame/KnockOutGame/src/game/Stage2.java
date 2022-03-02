package game;

import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * The Second Stage
 */
public class Stage2 extends GameStage {
    public Stage2(Game game) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        super(game);

        getP1().setPosition(new Vec2(-10f, 0f));
        getP1().setGravityScale(0f);
        getP1().setAngleDegrees(90);
        getP1().setWinCount(0);

        getP2().setPosition(new Vec2(10f, 0f));
        getP2().setGravityScale(0f);
        getP2().setAngleDegrees(-90);
        getP2().setWinCount(0);

        getBump1().setPosition(new Vec2(0, 7));
        getBump1().addCollisionListener(new BumperContact(getBump1(), getP1(), getP2()));

        getBump2().setPosition(new Vec2(0,7));

        getBump3().setPosition(new Vec2(0,-7));
        getBump3().addCollisionListener(new BumperContact(getBump3(), getP1(), getP2()));

        getSpeedup().setPosition(new Vec2(0,0));
        getSpeedup().setGravityScale(0);


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
        return "Stage2";
    }

}