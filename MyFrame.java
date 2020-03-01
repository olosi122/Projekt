package Projekt.Projekt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static void main(String[] args) throws IOException {
        MyFrame frame = new MyFrame();
        String cmd;

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
