package Projekt.States;

import Projekt.Buttons.Button1;
import Projekt.Buttons.Button2;
import Projekt.Buttons.ButtonH;
import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Operation.GameModel;
import Projekt.PowerUps.PowerUp;

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
        this.lvl1= new Button1(model,0,50);
        //this.lvl1= new Button1(model,S_WIDTH / 2 -100, S_HEIGHT / 2);
    }

    @Override
    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_ENTER)
            model.switchState(new Level1(model));
        if (key == KeyEvent.VK_ESCAPE)
            System.exit(0);
    }

    @Override
    public void update(GameModel enemies, ArrayList<Enemy> enemyArrayList, ArrayList<Beam> beamList) {;}

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) {
        //drawBg(g, bgColor);
        lvl1.draw(g);
    }
}