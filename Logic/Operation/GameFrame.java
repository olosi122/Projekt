package Projekt.Logic.Operation;

/**
 * GameFrame har sitt främsta syfte att producera själva fönstret som panelen (och allt annat för den delen).
 * Sedan vill vi att musiken ska pågå så länge fönstret är uppe (oavsett vilket State vi befinner oss i).
 */

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class GameFrame extends JFrame {


    public GameFrame(GameModel model) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(S_WIDTH, S_HEIGHT);
        this.add(new GamePanel(model));
        this.setVisible(true);
        playMusic("sounds/Tanks Loop.wav",true);
    }

    private static Clip playMusic(String path, boolean repeat) {
        AudioInputStream audioIn;

        try {
            audioIn = AudioSystem.getAudioInputStream(new File(path));

            DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioIn);
            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
            return clip;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
