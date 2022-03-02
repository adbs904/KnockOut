package game;

import javax.swing.text.View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//Allows the game to be played when the mouse enter the game window
public class GiveFocus implements MouseListener {

    private MyView view;

    /**
     * When the mouse enters the game window the game can be controlled
     * @param v The defined view window where the game is players
     */
    public GiveFocus(MyView v){
        this.view = v;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        view.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
