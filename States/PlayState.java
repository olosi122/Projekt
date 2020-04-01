package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Characters.Player;
import Projekt.Operation.GameModel;
import Projekt.Operation.Timer;
import Projekt.PowerUps.PowerUp;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public abstract class PlayState extends GameState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;
    private Player player;
    private Timer time;
    private long master = System.currentTimeMillis();
    private boolean right = false;
    private int q = 0;
    private int intervall = 1000;

    public PlayState(GameModel model) {
        super(model);
        informationText = "Press Escape To Return To The Menu";
        bgColor = new Color(154, 154, 154);
        fontColor = new Color(123, 178, 116);
        this.player = new Player();
        this.time = new Timer();

    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList);

    public Player getPlayer() {
        return this.player;
    }

    public Timer getTimer() {
        return this.time;
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

        time.draw(g);

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
    public void keyPressed(int key, GameModel model) {
        if (key == KeyEvent.VK_ESCAPE) {
            model.clearLevel();
            model.switchState(new MenuState(model));
        } else {
            player.keyPressed(key, model);
        }
    }
}
