package Projekt.Projekt;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Projekt.Projekt.Constants.S_HEIGHT;
import static Projekt.Projekt.Constants.S_WIDTH;

public class Level1 extends GameState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;

    /* Class only used for testing */
    private Tester tester;

    public Level1 (GameModel model) {
    super(model);
    informationText = "Press Escape To Return To The Menu";
    bgColor = new Color(78, 87, 100);
    fontColor = new Color(123, 178, 116);

    tester = new Tester();
}

    /*
        Draws information text to the screen.
     */
    @Override
    public void draw(Graphics g) {
        drawBg(g, bgColor);

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 20));
        g.drawString(informationText, (S_WIDTH / 2) - 200, S_HEIGHT / 2);

        tester.delegate(g);
    }

    @Override
    public void keyPressed(int key) {
        System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i PlayState");
        //System.out.println(key); //an integer connected with every keybord button

        if (key == KeyEvent.VK_ESCAPE)
            model.switchState(new MenuState(model));
    }

    @Override
    public void update() {
        tester.delegate(null);
    }
}

