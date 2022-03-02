/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Mar 2021
 */

package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

/**
 * Keyboard controls for Player 2
 */
public class P2Controller implements KeyListener {

    private GameStage stage;

    /**
     * Gives Player 2 control of their character
     * @param stage the current stage being played on
     */
    public P2Controller(GameStage stage){
       this.stage = stage;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /* The left and right keys change the angle of the player, this calculated angle is used to
   determine what direction the player will move in when the up key is pressed, you can only move
   and turn if you pressed left or right before up */

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            stage.getP2().setAngularVelocity(5);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            stage.getP2().setAngularVelocity(-5);
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            stage.getP2().setLinearVelocity(new Vec2(Math.round(stage.getP2().getSpeed()*(Math.sin((Math.round(stage.getP2().getAngle()))))),Math.round(stage.getP2().getSpeed()*(-Math.cos((Math.round(stage.getP2().getAngle())))))));
        }
    }

    //When any of the keys are released the motion that they were given is stopped
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            stage.getP2().setLinearVelocity(new Vec2 (0,0));
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            stage.getP2().setAngularVelocity(0);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            stage.getP2().setAngularVelocity(0);
        }
    }

    // Allows the player to continue controlling their character in each stage
    public void updatePlayer2(GameStage stage){this.stage = stage;}
}
