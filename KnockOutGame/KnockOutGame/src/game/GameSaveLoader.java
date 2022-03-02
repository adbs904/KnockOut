/**
 * @author      Nubbannie, Saani, email
 * @version     1.0
 * @since       Feb 2021
 */

package game;

import javax.imageio.IIOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Allows the player to create a save state and load it
 */
public class GameSaveLoader {


    /**
     * Saves current player score and stage progression
     * <p>
     * Reads the current score for both players and current stage the players are on to a .txt file
     *
     * @param stage Current stages players are on
     * @param fileName file data is saved to
     *
     * @return Description of what the method returns.
     */
    public static void save(GameStage stage, String fileName) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append);
            writer.write(stage.getStageName() + "," +
                    stage.getP1().getWinCount() + "," +
                    stage.getP2().getWinCount() + "\n");

        }finally {
            if(writer != null) {
                writer.close();
            }
        }
    }


    /**
     * Loads the last save that was made
     * <p>
     * Reads the data on the .txt file and starts the stage
     *
     * @param  game current game state
     * @param  fileName description of all the method's variables
     * @return Description of what the method returns.
     */
 public static GameStage load(Game game,String fileName) throws IOException {
     FileReader fr = null;
     BufferedReader reader = null;
     try {
         System.out.println("Reading " + fileName + " ...");
         fr = new FileReader(fileName);
         reader = new BufferedReader(fr);
         String line = reader.readLine();
         String[] tokens = line.split(",");
         String name = tokens[0];
         int p1Score = Integer.parseInt(tokens[1]);
         int p2Score = Integer.parseInt(tokens[2]);

         GameStage stage = null;
         if (name.equals("Stage1"))
             stage = new Stage1(game);
         else if (name.equals("Stage2"))
            stage = new Stage2(game);
         else if (name.equals("Stage3"))
             stage = new Stage3(game);
         else if (name.equals("Stage4"))
             stage = new Stage4(game);
         else if (name.equals("Stage5"))
            stage = new Stage5(game);

         stage.getP1().setWinCount(p1Score);
         stage.getP2().setWinCount(p2Score);

         return stage;


     } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
         game.getView().setErrorMessage("Audio could not be played");
     } catch (LineUnavailableException e) {
         e.printStackTrace();
         game.getView().setErrorMessage("Stage could not be found");
     } finally {
         if (reader != null) {
             reader.close();
         }
         if (fr != null) {
             fr.close();
         }
     }

     return null;
 }


}


