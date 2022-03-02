/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import javax.swing.*;
import java.io.IOException;

/**
 * GUI that allows the player to pause and save the game
 */
public class ControlPanel {
    private GameStage stage;
    private JPanel mainPanel;
    private JButton pauseButton;
    private JButton quitButton;
    private JButton restartButton;
    private JButton saveButton;
    private JButton loadSaveButton;

    public ControlPanel(GameStage stage) {
        this.stage = stage;
        quitButton.addActionListener(e -> System.exit(0));
        pauseButton.addActionListener(e -> stage.pause());
        restartButton.addActionListener(e -> stage.play());
        saveButton.addActionListener(e -> stage.saveGame());
        loadSaveButton.addActionListener(e -> stage.loadGame());

    }


    public JPanel getMainPanel() {return mainPanel;}
}