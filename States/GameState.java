package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Characters.Player;
import Projekt.Operation.GameModel;
import Projekt.Operation.Timer;
import Projekt.PowerUps.PowerUp;

import java.awt.*;
import java.util.ArrayList;

import static Projekt.Operation.Constants.S_WIDTH;
import static Projekt.Operation.Constants.S_HEIGHT;

public abstract class GameState {

    private GameModel model;

    public GameState(GameModel model) {
        this.model = model;
    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList);

    public abstract void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList);

    public abstract void keyPressed(int key,GameModel model);

    public void drawBg(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }
}

