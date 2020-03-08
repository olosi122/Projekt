package Projekt.Projekt;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;

//States
//Buffra bilder
//Keyboard input för röra sig med piltangenterna

public class MyFrame extends JFrame {

    private static Scanner keyboard;
    private DrawingArea area;
    private ArrayList<Image> beamList = new ArrayList<>();
    //private Key lastmovement;
    private boolean direction; //true right

    public MyFrame() {
        super("Window");
        keyboard = new Scanner(System.in);
        this.setSize(1600, 800);
        DrawingArea area = new DrawingArea();
        this.add(area);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    private static Clip playASound(String path, boolean repeat) {
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


    public static void main(String[] args) throws IOException {
        MyFrame frame = new MyFrame();
        String cmd;
        playASound("Tanks Loop.wav",true);

        do {
            //frame.area.updateYourself();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }
}
