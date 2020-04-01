package Projekt.Logic.States;

import Projekt.Graphics.Characters.*;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.Star;

import java.util.ArrayList;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Level1 extends PlayState {

    public Level1(GameModel model) {
        super(model);
        model.addPlat(new Platform(0, S_HEIGHT - 50, S_WIDTH, 100));
        model.addPlat(new Platform(100, 400, 100, 10));
        model.addPlat(new Platform(S_WIDTH - 200, 400, 100, 10));
        model.addPlat(new Platform((S_WIDTH / 2) - 50, 250, 100, 10));
        model.addPower(new Star(S_WIDTH / 2 - 15, 200));
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
        if (System.currentTimeMillis() - getMaster() > getIntervall()) {
            setIntervall(10);
            if (getRight()) {
                model.addEnemy(new Dumb(true,getPlayer().getY()));
                setRight(false);
            } else {
                model.addEnemy(new Dumb(false,getPlayer().getY()));
                setRight(true);
            }
            setMaster();
        }

        model.removeEnemy();
        model.removeBeam();
        model.removePower();

        getPlayer().update();

        model.checkCollision(getPlayer());

        getTimer().update();
    }
}

