package Projekt.Projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import static Projekt.Projekt.Constants.S_HEIGHT;
import static Projekt.Projekt.Constants.S_WIDTH;

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
        model.draw(g);
    }
}

