package Projekt.Operation;

import Projekt.Operation.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


import static Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Operation.Constants.S_WIDTH;

public class GamePanel extends JPanel {

    private GameModel model;

    public GamePanel(final GameModel model) {
        this.model = model;

        this.setPreferredSize(new Dimension(S_WIDTH, S_HEIGHT));
        this.setFocusable(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                model.keyPressed(e.getKeyCode());
            }
        });
    }

    public void paintComponent(Graphics g) {
        try {
            model.draw(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

