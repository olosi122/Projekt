package Projekt.Logic.States;

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
    private Font textFont = new Font("Monospace",Font.PLAIN,35);
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
        HashMap<Integer,Integer> scores = (HashMap<Integer,Integer>) in.readObject();

        String temp1 = scores.get(1).toString();
        String temp2 = scores.get(1).toString();

        g.setColor(textColor);
        g.setFont(textFont);
        g.drawString("Highscore Level 1:",S_WIDTH/2-150,S_HEIGHT/2-100);
        g.drawString("Highscore Level 2:",S_WIDTH/2-150,S_HEIGHT/2-50);
        g.setColor(scoreColor);
        g.drawString(temp1,S_WIDTH/2+150,S_HEIGHT/2-100);
        g.drawString(temp2,S_WIDTH/2+150,S_HEIGHT/2-100);

    }

    @Override
    public void keyPressed(int key, GameModel model) {
        if (key == KeyEvent.VK_ESCAPE)
            model.switchState(new MenuState(model));
    }

    @Override
    public void getTime() {;}
}
