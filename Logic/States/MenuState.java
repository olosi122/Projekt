package Projekt.Logic.States;

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Logic.Operation.Constants.S_WIDTH;
import static Projekt.Logic.Operation.Constants.S_HEIGHT;


public class MenuState extends GameState {
    private Color bgColor = Color.lightGray;
    private Color textColor = Color.black;
    private Font textFont = new Font("Monospace",Font.PLAIN,35);

    public MenuState(GameModel model) {
        super(model);
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {

    }

    @Override
    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
        if (key == KeyEvent.VK_1)
            model.switchState(new Level1(model));
        if (key == KeyEvent.VK_2)
            model.switchState(new Level2(model));
        if (key == KeyEvent.VK_3)
            model.switchState(new Highscore(model));
    }

    @Override
    public void getTime() {;}

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) {
        drawBg(g, bgColor);

        g.setColor(textColor);
        g.setFont(textFont);
        g.drawString("Tryck 1 : Level 1",S_WIDTH/2-150,S_HEIGHT/2-100);
        g.drawString("Tryck 2 : Level 2",S_WIDTH/2-150,S_HEIGHT/2-50);
        g.drawString("Tryck 3 : Heighscore",S_WIDTH/2-150,S_HEIGHT/2);
        g.drawString("Tryck Esc : Avsluta",S_WIDTH/2-150,S_HEIGHT/2+50);
    }
}