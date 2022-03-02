/*package game;

import city.cs.engine.*;
import game.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class GameWorld extends World {

    private PlayerIcon p1;
    private PlayerIcon2 p2;
    private Bumper bump1;
    private PowerUp speedup;
    private StaticBody wall1;
    private StaticBody wall2;
    private StaticBody ceiling;
    private StaticBody floor;

    public GameWorld() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        Shape shape = new BoxShape(32, 0.5f);
        floor = new StaticBody(this, shape);
        floor.setPosition(new Vec2(0f, -18.5f));

        Shape platform1Shape = new BoxShape(32f, 0.5f);
        ceiling = new StaticBody(this, platform1Shape);
        ceiling.setPosition(new Vec2(0f, 18.5f));

        Shape wallShape = new BoxShape(0.5f, 18f);
        wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-32.5f, 0f));

        wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(32.5f, 0f));

        p1 = new PlayerIcon(this);
        p1.setPosition(new Vec2(-10f, 0f));
        p1.setGravityScale(0f);
        p1.setAngleDegrees(90);

        p2 = new PlayerIcon2(this);
        p2.setPosition(new Vec2(10f, 0f));
        p2.setGravityScale(0f);
        p2.setAngleDegrees(-90);

        speedup = new PowerUp(this);
        speedup.setPosition(new Vec2(18,8));
        speedup.setGravityScale(0f);
        PowerUpGet speed = new PowerUpGet(speedup,p1,p2);
        speedup.addCollisionListener(speed);

        bump1 = new Bumper(this);
        bump1.setPosition(new Vec2(0,0));
        BumperContact bumper = new BumperContact(bump1,p1,p2);
        bump1.addCollisionListener(bumper);

        Blastzone blastzone = new Blastzone(wall1,wall2,floor,ceiling,p1,p2);
        wall1.addCollisionListener(blastzone);
        wall2.addCollisionListener(blastzone);
        floor.addCollisionListener(blastzone);
        ceiling.addCollisionListener(blastzone);

    }

    public PlayerIcon getP1() { return p1; }

    public PlayerIcon2 getP2() { return p2; }

}
*/