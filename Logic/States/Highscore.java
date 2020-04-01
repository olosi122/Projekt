package Projekt.Logic.States;

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.util.ArrayList;

public class Highscore extends GameState {

    public Highscore(GameModel model) {
        super(model);

    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {

    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) {

    }

    @Override
    public void keyPressed(int key, GameModel model) {

    }
}
