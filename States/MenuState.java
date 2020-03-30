package Projekt.Projekt.States;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.Operation.GameModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Projekt.Operation.Constants.S_WIDTH;

public class MenuState extends GameState {
    private String informationText;
    private Color bgColor;
    private Color fontColor;


    public MenuState(GameModel model) {
        super(model);

        informationText = "Press Enter To Play";
        bgColor = new Color(78, 172, 176);
        fontColor = new Color(200, 198, 130);
    }

    /*
    Draws information text to the screen
    */
    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
        drawBg(g, bgColor);

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 30));
        g.drawString(informationText, (S_WIDTH / 2) - 150, S_HEIGHT / 2);
    }

    @Override
    public void keyPressed(int key, GameModel model) {
        System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i MenuState");

        if (key == KeyEvent.VK_ENTER)
            model.switchState(new Level1(model));
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    @Override
    public void update(GameModel enemies, ArrayList<Enemy> enemyArrayList, ArrayList<Beam> beamList) {;}
}