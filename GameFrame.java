package Projekt.Projekt;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static Projekt.Projekt.Constants.S_HEIGHT;
import static Projekt.Projekt.Constants.S_WIDTH;

//Buffra bilder
//Keyboard input för röra sig med piltangenterna

public class GameFrame extends JFrame {


    public GameFrame(GameModel model) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(S_WIDTH, S_HEIGHT);
        DrawingArea area = new DrawingArea();
        this.add(new GamePanel(model));
        this.setVisible(true);
        //playMusic("sounds/Tanks Loop.wav",true);
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
