package Projekt.Logic.States;

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static Projekt.Logic.Operation.Constants.S_WIDTH;
import static Projekt.Logic.Operation.Constants.S_HEIGHT;

public abstract class GameState {

    private GameModel model;

    public GameState(GameModel model) {
        this.model = model;
    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList);

    public abstract void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) throws IOException;

    public abstract void keyPressed(int key,GameModel model);

    public void drawBg(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }
}

