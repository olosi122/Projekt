package Projekt.Logic.Operation;

/**
 * GamePanel är något unik i det att här finner vi hela programmets ända paintComponent. Detta betyder att
 * allting ritas ut av detta enasamma "Graphics g" som skickas runt till de andra programmens funktioner "draw"
 * vilket tillåter dem att rita ut på panelen. Fördelningen av vad som ritas ut sker självklart i GameModel som håller
 * reda på vilket State som är aktivit. Detta betyder att allting är ordnat efter koordinater i planet,
 * inte färdiga layout-strukturer.
 *
 * Genom att sätta panelen till "Focusable(true)" samt en integrerad "Keylistener" så kan alla spelets states
 * användas av tangetbordet, ty de har samma lyssnare.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

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
                try {
                    model.keyPressed(e.getKeyCode());
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        try {
            model.draw(g);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

