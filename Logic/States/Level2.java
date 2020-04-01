package Projekt.Logic.States;

/**
 * Underklasserna till PlayState innehåller många intressanta saker. Till exempel så finns banans layout
 * i form av plattformar och powerups. Förutom att ha en egen "update", vilket krävs för att skilja på vilka fiender
 * som ska aktiveras, så hanteras även updateringen av Highscore här med uppladdning till en extern fil.
 * Dessa skiljer sig åt för de olika banorna då de ska uppdatera olika nycklar i Hashmappen som de sparas i.
 */

import Projekt.Graphics.Characters.*;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.Mushroom;
import Projekt.Graphics.PowerUps.Star;
import Projekt.Logic.Operation.Timer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Level2 extends PlayState {

    private Timer time;

    public Level2(GameModel model) {
        super(model);
        model.addPlat(new Platform(0, S_HEIGHT - 50, S_WIDTH, 100));
        model.addPlat(new Platform(100, 250, 100, 10));
        model.addPlat(new Platform(S_WIDTH - 200, 250, 100, 10));
        model.addPlat(new Platform((S_WIDTH / 2) - 50, 400, 100, 10));
        model.addPower(new Star(135, 200, getPlayer()));
        model.addPower(new Mushroom(S_WIDTH - 165, 200, getPlayer()));
        this.time = new Timer();
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) throws IOException, ClassNotFoundException {
        if (System.currentTimeMillis() - getMaster() > getIntervall()) {
            setIntervall(10);
            if (getRight()) {
                model.addEnemy(new Smart(true, getPlayer().getY(), getPlayer()));
                setRight(false);
            } else {
                model.addEnemy(new Smart(false, getPlayer().getY(), getPlayer()));
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

    @Override
    protected Timer getTimer() {
        return this.time;
    }

    @Override
    public void getTime() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream (
                new FileInputStream(new File("savefile.xyz")));
        HashMap<Integer, Integer> scores = (HashMap<Integer, Integer>) in.readObject();

        if (scores.get(2) == null || this.time.getTime() >= scores.get(2)) {
            scores.remove(2);
            scores.put(2,this.time.getTime());
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(new File("savefile.xyz")));
            out.writeObject(scores);
        }
    }
}
