package Projekt.Projekt.States;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.Operation.GameModel;

import java.awt.*;
import java.util.ArrayList;

import static Projekt.Projekt.Operation.Constants.S_WIDTH;
import static Projekt.Projekt.Operation.Constants.S_HEIGHT;

public abstract class GameState {

    private GameModel model;

    public GameState(GameModel model) {
        this.model = model;
    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList);

    public abstract void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList);

    public abstract void keyPressed(int key,GameModel model);

    public void drawBg(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }

    /*
    public int getX(){ return 0;}

    public int getY() {return 0;}

    public boolean getDir(){return true;}

    public void activate() {}

    public void deactivate() {}

     */
}

