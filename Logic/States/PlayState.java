package Projekt.Logic.States;

/**
 * Playstate är en parent-klass till både Level1 och Level2 och en underklasss till GameState.
 * Denna hanterar mycket av den gemensamma spellogiken som kommer gälla för alla banor man
 * kan tänkas skapa i spelet. De mer specifika funktionerna överskuggas senare i de enskilda
 * banorna efter behov.
 *
 */

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Graphics.Characters.Player;
import Projekt.Logic.Operation.GameModel;
import Projekt.Logic.Operation.Timer;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;

public abstract class PlayState extends GameState {

    private Color bgColor;
    private Player player;
    private long master = System.currentTimeMillis();
    private boolean right = false;
    private int intervall = 1000;

    public PlayState(GameModel model) {
        super(model);
        bgColor = new Color(154, 154, 154);
        this.player = new Player();
    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) throws IOException, ClassNotFoundException;

    public Player getPlayer() {
        return this.player;
    }

    public void setIntervall(int i) {
        this.intervall=this.intervall-i;
    }

    public void setRight(boolean b) {
        this.right=b;
    }

    public void setMaster() {
        this.master = System.currentTimeMillis();
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) throws IOException {
        drawBg(g, bgColor);

        player.draw(g);

        this.getTimer().draw(g);

        for (Platform platform : platList) {
            platform.draw(g);
        }

        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }

        for (Beam beam : beamList) {
            beam.draw(g);
        }

        for (PowerUp power : powerList) {
            power.draw(g);
        }

    }

    protected abstract Timer getTimer();

    public long getMaster() {
        return this.master;
    }

    public boolean getRight() {
        return this.right;
    }

    public int getIntervall() {
        return this.intervall;
    }

    @Override
    public void keyPressed(int key, GameModel model) throws IOException, ClassNotFoundException {
        if (key == KeyEvent.VK_ESCAPE) {
            this.getTime();
            model.clearLevel();
            model.switchState(new MenuState(model));
        } else {
            player.keyPressed(key, model);
        }
    }

    public abstract void getTime() throws IOException, ClassNotFoundException;
}
