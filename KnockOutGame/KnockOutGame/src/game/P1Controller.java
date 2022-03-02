/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import org.jbox2d.common.Vec2;

import java.awt.event.AdjustmentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.Math;

/**
 * Keyboard controls for Player 1
 */
public class P1Controller implements KeyListener {


    private GameStage stage;
    private Game game;

    /**
     * Gives Player 1 control of their character
     * @param stage The current stage that is being played on
     */
    public P1Controller(GameStage stage){
        this.stage = stage;
        this.game = stage.getGame();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    /* D and A keys change the angle of the player, this calculated angle is used to
    determine what direction the player will move in when W is pressed, you can only move
    and turn if you pressed A or D before W */
    @Override
    public void keyPressed(KeyEvent e ) {
        if(e.getKeyCode() == KeyEvent.VK_A) {
            stage.getP1().setAngularVelocity(5);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            stage.getP1().setAngularVelocity(-5);
        }else if(e.getKeyCode() == KeyEvent.VK_W) {
            stage.getP1().setLinearVelocity(new Vec2(Math.round(stage.getP1().getSpeed()*(Math.sin((Math.round(stage.getP1().getAngle()))))),Math.round(stage.getP1().getSpeed()*(-Math.cos((Math.round(stage.getP1().getAngle())))))));
        }
    }


//When any of the keys are released the motion that they were given is stopped
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            stage.getP1().setLinearVelocity(new Vec2 (0,0));
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            stage.getP1().setAngularVelocity(0);
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            stage.getP1().setAngularVelocity(0);
        }
    }

    // Allows the player to continue controlling their character in each stage
    public void updatePlayer1(GameStage stage){this.stage = stage;}

}