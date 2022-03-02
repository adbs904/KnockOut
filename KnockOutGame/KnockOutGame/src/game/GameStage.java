/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/* This Class creates a stage that all stages are based on, helping the reduce repeated code*/

/**
 * Used to create stages
 */
public abstract class GameStage extends World {

    /**
     * The bodies that will be in stages
     */
    private PlayerIcon p1;
    private PlayerIcon2 p2;
    private Bumper bump1;
    private Bumper bump2;
    private Bumper bump3;
    private StaticBody wall1;
    private StaticBody wall2;
    private StaticBody ceiling;
    private StaticBody floor;
    private PowerUp speedup;
    private Game game;

    /**
     * Creates a stage
     * <p>
     * Creates a stage with other bodies
     *
     * @param game current game state
     *
     * @return Description of what the method returns.
     */
    public GameStage (Game game) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        p1 = new PlayerIcon(this);
        p2 = new PlayerIcon2(this);
        bump1 = new Bumper(this);
        bump2 = new Bumper(this);
        bump3 = new Bumper(this);
        speedup = new PowerUp(this);
        this.game = game;



        wall1 = new StaticBody(this);
        wall2 = new StaticBody(this);
        ceiling = new StaticBody(this);
        floor = new StaticBody(this);

        Shape shape = new BoxShape(32, 0.5f);
        floor = new Walls(this, shape);
        floor.setPosition(new Vec2(0f, -18.5f));

        Shape platform1Shape = new BoxShape(32f, 0.5f);
        ceiling = new Walls(this, platform1Shape);
        ceiling.setPosition(new Vec2(0f, 18.5f));

        Shape wallShape = new BoxShape(0.5f, 18f);
        wall1 = new Walls(this, wallShape);
        wall1.setPosition(new Vec2(-32.5f, 0f));

        wall2 = new Walls(this, wallShape);
        wall2.setPosition(new Vec2(32.5f, 0f));

        Blastzone blastzone = new Blastzone(wall1,wall2,floor,ceiling,p1,p2);
        wall1.addCollisionListener(blastzone);
        wall2.addCollisionListener(blastzone);
        floor.addCollisionListener(blastzone);
        ceiling.addCollisionListener(blastzone);

        PowerUpGet speed = new PowerUpGet(speedup,p1,p2);
        speedup.addCollisionListener(speed);

        Winner1 win1 = new Winner1(this,game);
        Winner2 win2 = new Winner2(this,game);

        p2.addCollisionListener(win1);
        p1.addCollisionListener(win2);
    }


    /**
     * Gets Player 1 in the current stage
     * @return
     */
    public PlayerIcon getP1(){
        return p1;
    }

    /**
     * Gets Player 2 in the current stage
     * @return
     */
    public PlayerIcon2 getP2() {
        return p2;
    }

    /**
     * Gets Bumper 1 in the current stage
     * @return
     */
    public Bumper getBump1() {
        return bump1;
    }

    /**
     * Gets Bumper 2 in the current stage
     * @return
     */
    public Bumper getBump2() { return bump2; }

    /**
     * Gets Bumper 3 in the current stage
     * @return
     */
    public Bumper getBump3() { return bump3; }

    /**
     * Gets the speed up icon in th current game
     * @return
     */
    public PowerUp getSpeedup() { return speedup;}

    /**
     * Gets the current game state
     * @return
     */
    public Game getGame() {return game; }


    /**
     * A boolean that checks if Player 1 has won enough rounds to progress to the next level
     * @return
     */
    public abstract boolean p1Wins();

    /**
     * A boolean that checks if Player 2 has won enough rounds to progress to the next level
     * @return
     */
    public abstract boolean p2Wins();

    /**
     * Allows the game to be paused
     */
    public void pause() { game.stop();}

    /**
     * Allows the game to be unpaused
     */
    public void play() { game.start();}


    /**
     * Allows the game state to be saved
     */
    public void saveGame() {game.saveGame();}

    /**
     * Allows the saved state to be loaded
     */
    public void loadGame() {    try {
        GameStage stage = GameSaveLoader.load(game, "data/save.txt");
        game.setStage(stage);
    } catch (IOException ioException) {
        ioException.printStackTrace();
        game.getView().setErrorMessage("Cannot load game");
    }}

    /**
     * Finds the name of the stage currently being played
     * @return
     */
    public abstract String getStageName();



}
