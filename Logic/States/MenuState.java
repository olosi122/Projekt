package Projekt.Logic.States;

import Projekt.Buttons.Button1;
import Projekt.Buttons.Button2;
import Projekt.Buttons.ButtonH;
import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MenuState extends GameState {
    private Color bgColor;
    private Button1 lvl1;
    private Button2 lvl2;
    private ButtonH high;

    public MenuState(GameModel model) {
        super(model);
        bgColor = new Color(78, 172, 176);
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {

    }

    @Override
    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_ENTER)
            model.switchState(new Level2(model));
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
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) {
        drawBg(g, bgColor);

    }
}