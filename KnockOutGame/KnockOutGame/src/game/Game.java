package game;

import city.cs.engine.*;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;


/**
 * A world with some bodies.
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameStage stage;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private MyView view;

    private SoundClip backMusic1;

    private SoundClip backMusic2;

    private SoundClip backMusic3;

    private P1Controller controller1;

    private P2Controller controller2;



    /**
     * Initialise a new Game.
     */
    public Game() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        //Starts game on Stage 1
        stage = new Stage1(this);


        //The view is set up, adding. also adding foreground elements
        view = new MyView(stage, 640, 360,stage.getP1(), stage.getP2());
        view.setZoom(12f);
        //Changes round number to number of rounds needed to progress
        view.updateRoundNum(5);

        //Allows the game to be played when the mouse is inside the window
        view.addMouseListener(new MouseHandler(view));

        //Setup for the controllers of each player
       // controller1 = new P1Controller(stage.getP1());
        controller1 = new P1Controller(stage);
        view.addKeyListener(controller1);

        controller2 = new P2Controller(stage);
        view.addKeyListener(controller2);

        view.addMouseListener(new GiveFocus(view));


        //Creates window that the game is played in
        final JFrame frame = new JFrame("KnockOut");
        frame.add(view);

        //Creates Panel to the right of the screen, allowing the game to be paused, etc.
        ControlPanel controlPanel = new ControlPanel(stage);
        frame.add(controlPanel.getMainPanel(), BorderLayout.EAST);


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);

        frame.pack();

        frame.setVisible(true);


        stage.start();



        try {
            backMusic1 = new SoundClip("data/track3.wav");
            backMusic2 = new SoundClip("data/track2.wav");
            backMusic3 = new SoundClip("data/track4.wav");// Open an audio input stream
            backMusic1.loop();  // Set it to continuous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            view.setErrorMessage("Error with the audio");
        }

    }




    /**
     * Run the game.
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        new Game();

    }

    /**
     * Sets the new stage that will be played on
     * @throws UnsupportedAudioFileException
     * @throws IOException
     * @throws LineUnavailableException
     */
    public void goToNextStage() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //Sets Stage 2 as the new Stage


        if (stage instanceof Stage1) {
                stage.stop();

                stage = new Stage2(this);

                view.setWorld(stage);

                view.setZoom(12);

                // Allows player count to be reset for the new stage
                view.updatePlayer1(stage.getP1());

                view.updatePlayer2(stage.getP2());

                //Sets the new round number for Stage 2 in MyView
                view.updateRoundNum(5);

                //Allows the players to continue controlling their character in the new stage
                controller1.updatePlayer1(stage);

                controller2.updatePlayer2(stage);

                stage.start();

                backMusic1.stop();
                backMusic2.stop();
                backMusic3.stop();


                //Loops the new track for Stage 2 and Stage 3
               try { backMusic2 = new SoundClip("data/track2.wav");
                    backMusic2.loop(); } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    System.out.println(e);
                   view.setErrorMessage("Error with the audio");
                }

        // Sets Stage 3 as the new Stage
        } else if (stage instanceof Stage2){
                stage.stop();

                stage = new Stage3(this);

                view.setWorld(stage);

                view.setZoom(12);

            // Allows player count to be reset for the new stage
                view.updatePlayer1(stage.getP1());

                view.updatePlayer2(stage.getP2());

                //Sets round number for Stage 3 in MyView
                view.updateRoundNum(5);

            //Allows the players to continue controlling their character in the new stage
                controller1.updatePlayer1(stage);

                controller2.updatePlayer2(stage);

                stage.start();

        // Sets Stage 4 as the new Stage
        } else if (stage instanceof Stage3){
            stage.stop();

            stage = new Stage4(this);

            view.setWorld(stage);

            view.setZoom(12);

            // Allows player count to be reset for the new stage
            view.updatePlayer1(stage.getP1());

            view.updatePlayer2(stage.getP2());

            //Sets round number for Stage 4 in MyView
            view.updateRoundNum(7);

            //Allows the players to continue controlling their character in the new stage
            controller1.updatePlayer1(stage);

            controller2.updatePlayer2(stage);

            stage.start();

            backMusic1.stop();
            backMusic2.stop();
            backMusic3.stop();

            //Loops the new track for Stage 4 and Stage 5
            try { backMusic3 = new SoundClip("data/track4.wav");
                backMusic3.loop(); } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
                view.setErrorMessage("Error with the audio");
            }

        //Sets Stage 5 as the new Stage
        }else if (stage instanceof Stage4){
            stage.stop();

            stage = new Stage5(this);

            view.setWorld(stage);

            view.setZoom(12);

            // Allows player count to be reset for the new stage
            view.updatePlayer1(stage.getP1());

            view.updatePlayer2(stage.getP2());

            //Sets round number for Stage 5 in My View
            view.updateRoundNum(13);

            //Allows the players to continue controlling their character in the new stage
            controller1.updatePlayer1(stage);

            controller2.updatePlayer2(stage);

            stage.start();

        } else if (stage instanceof Stage5) {
            //Closes the game since we have reached the last stage
                System.exit(0);
            }
        }

    /**
     * Pauses the game
     */
    public void stop() {stage.stop();}

    /**
     * Unpauses the game
     */
    public void start() {stage.start();}

    /**
     * Creates a current save of the game
     */
    public void saveGame() { try {
        GameSaveLoader.save(stage,"data/save.txt");
    } catch (IOException ioException) {
        ioException.printStackTrace();
        view.setErrorMessage("Save could not be made");
    }}


    /**
     * Gets the current stage being played on
     * @return
     */
    public GameStage getStage() {
        return stage;
    }

    public MyView getView() {
        return view;
    }

    /**
     * Sets the stag to be played on
     * @param stage
     */
    public void setStage(GameStage stage){
        this.stage.stop();

        this.stage = stage;

        view.setWorld(stage);

        view.setZoom(12);

        // Allows player count to be reset for the new stage
        view.updatePlayer1(stage.getP1());

        view.updatePlayer2(stage.getP2());

        //Sets the new round number for Stage 2 in MyView
        view.updateRoundNum(5);

        //Allows the players to continue controlling their character in the new stage
        controller1.updatePlayer1(stage);

        controller2.updatePlayer2(stage);

        this.stage.start();

    }
}

