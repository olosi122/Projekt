package Projekt.Projekt.Operation;

import Projekt.Projekt.Operation.GameFrame;
import Projekt.Projekt.Operation.GameModel;

import java.awt.*;

import static Projekt.Projekt.Operation.Constants.ms;

public class Main {

    public static void main(String[] args) {

        boolean gameover = false;
        boolean winner = false;

        GameModel model = new GameModel();
        GameFrame frame = new GameFrame(model);

        while (!gameover || !winner) {

            long lastTime = System.currentTimeMillis();

            model.update();
            frame.repaint();

            long timer = System.currentTimeMillis() - lastTime;

            Toolkit.getDefaultToolkit().sync();

            try {
                Thread.sleep((long) Math.max(ms - timer, 0));
            } catch (InterruptedException e) {
                System.out.println("time delay");
                System.out.println(ms - timer);
            }
        }
    }
}
