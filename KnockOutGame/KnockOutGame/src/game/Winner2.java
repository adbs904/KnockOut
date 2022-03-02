/**
 * @author      Nubbannie, Saani,
 * @version     1.0
 * @since       Mar 2021
 */

package game;

import city.cs.engine.BoxShape;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;
import org.jbox2d.collision.Collision;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


/**
 * Collision listener that allows the game to progress when Player 2 has met the requirements
 */
public class Winner2 implements CollisionListener {

    private GameStage stage;
    private Game game;


    /**
     * Allows the game to progress when Player 2's score has reached a certain amount
     * @param stage stage being currently played
     * @param game the game state
     */
    public Winner2(GameStage stage, Game game) {
        this.stage = stage;
        this.game = game;

    }

    @Override
    //when one of the players has won enough rounds the game moves on to the next stage
    public void collide(CollisionEvent e)  {
        if (e.getOtherBody() instanceof Walls && stage.p2Wins() == true )
        {
            try {
                game.goToNextStage();
            } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                unsupportedAudioFileException.printStackTrace();
                game.getView().setErrorMessage("Audio could not be played");
            } catch (IOException ioException) {
                ioException.printStackTrace();
                game.getView().setErrorMessage("Stage could not be loaded");
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
                game.getView().setErrorMessage("Stage could not be found");
            }
        }

    }
}