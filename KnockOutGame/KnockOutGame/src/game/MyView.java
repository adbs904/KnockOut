package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

/**
 * Sets the game's window
 */
public class MyView extends UserView {
    private Image background;
    private PlayerIcon p1;
    private PlayerIcon2 p2;
    private int rounds = 5;
    public String errorMessage = "";

    /**
     * Creates the view in which the game is played
     * @param w
     * @param width Width of the window
     * @param height Height of the window
     * @param p1 Player 1's character
     * @param p2 Player 2's character
     */
    public MyView(World w, int width, int height, PlayerIcon p1, PlayerIcon2 p2) {
        super(w, width, height);

        background = new ImageIcon("data/edit background.png").getImage();
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        //adds a background to the game
        g.drawImage(background, 0, 0, this);
    }

    /**
     * Sets the UI that appears in the foreground giving information on the rounds being played and stage progression
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        /*Creates the scoreboard at the top of the screen, keeping track of each players score and showing the needed
        rounds to progress*/
        g.setFont(new Font("Arial", Font.BOLD, 19));
        g.drawString("P1 Rounds Won: " + p1.getWinCount(), 10, 20);
        g.drawString("P2 Rounds Won: " + p2.getWinCount(), 455, 20);
        g.drawString("First to " + rounds, 280,30 );
        g.drawString(errorMessage,10,350);
    }

    /**
     * Allows the score for Player 1 to be set when moving on the the next stage
     * @param p1 The current Player 1
     */
    public void updatePlayer1(PlayerIcon p1){this.p1 = p1;}

    /**
     * Allows the score for Player 2 to be set when moving on the the next stage
     * @param p2 The current Player 2
     */
    public void updatePlayer2(PlayerIcon2 p2){this.p2 = p2;}

    /**
     * Sets the rounds that appear in the background
     * @param rounds Number of rounds
     */
    public void updateRoundNum(int rounds){this.rounds = rounds;}

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
