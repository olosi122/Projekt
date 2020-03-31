package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Operation.GameModel;
import Projekt.PowerUps.PowerUp;

import java.awt.*;
import java.util.ArrayList;

public abstract class PlayState extends GameState {

    public PlayState(GameModel model) {
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
