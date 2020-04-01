package Projekt.Logic.States;

import Projekt.Graphics.Characters.*;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.Mushroom;
import Projekt.Graphics.PowerUps.Star;

import java.io.IOException;
import java.util.ArrayList;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Level2 extends PlayState {

    public Level2(GameModel model) {
        super(model);
        model.addPlat(new Platform(0, S_HEIGHT - 50, S_WIDTH, 100));
        model.addPlat(new Platform(100, 250, 100, 10));
        model.addPlat(new Platform(S_WIDTH - 200, 250, 100, 10));
        model.addPlat(new Platform((S_WIDTH / 2) - 50, 400, 100, 10));
        model.addPower(new Star(135,200));
        model.addPower(new Mushroom(S_WIDTH-165,200));
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) throws IOException {
        if (System.currentTimeMillis() - getMaster() > getIntervall()) {
            setIntervall(10);
            if (getRight()) {
                model.addEnemy(new Smart(true,getPlayer().getY(),getPlayer()));
                setRight(false);
            } else {
                model.addEnemy(new Smart(false,getPlayer().getY(), getPlayer()));
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
