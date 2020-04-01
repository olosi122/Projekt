package Projekt.Logic.States;

/**
 * Denna klassen visar upp en egen skärm (inte fönster) som visar upp innehållet i filen för Highscore.
 * Detta laddas om varje gång man skapar ett nytt state, och de andra som inte längre är relevanta tas hand om av
 * skräp-hanteraren.
 * Viktigt här är att undvika att läsa en fil som inte finns, och nullpointer som kan uppstå i fallet av HashMap:en.
 */

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Highscore extends GameState {

    private Color bgColor = Color.lightGray;
    private Color textColor = Color.green;
    private Font textFont = new Font("Monospace", Font.PLAIN, 35);
    private Color scoreColor = Color.red;

    public Highscore(GameModel model) {
        super(model);
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) throws IOException, ClassNotFoundException {
        drawBg(g, bgColor);

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("savefile.xyz")));
        HashMap<Integer, Integer> scores = (HashMap<Integer, Integer>) in.readObject();

        g.setColor(textColor);
        g.setFont(textFont);
        g.drawString("Highscore Level 1:", S_WIDTH / 2 - 150, S_HEIGHT / 2 - 100);
        g.drawString("Highscore Level 2:", S_WIDTH / 2 - 150, S_HEIGHT / 2 - 50);
        g.setColor(scoreColor);

        if (scores.get(1) == null) {
            ;
        } else {
            String temp1 = scores.get(1).toString();
            g.drawString(temp1, S_WIDTH / 2 + 150, S_HEIGHT / 2 - 100);
        }
        if (scores.get(2) == null) {
            ;
        } else {
            String temp2 = scores.get(2).toString();
            g.drawString(temp2, S_WIDTH / 2 + 150, S_HEIGHT / 2 - 50);
        }
    }

    @Override
    public void keyPressed(int key, GameModel model) throws IOException {
        if (key == KeyEvent.VK_ESCAPE)
            model.switchState(new MenuState(model));
    }

    @Override
    public void getTime() {;}
}
