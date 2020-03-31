package Projekt.Projekt.Operation;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Dumb;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.Characters.Player;
import Projekt.Projekt.Maps.Level;
import Projekt.Projekt.Maps.Platform;
import Projekt.Projekt.States.GameState;
import Projekt.Projekt.States.Level1;
import Projekt.Projekt.States.MenuState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private ArrayList<Platform> platList = new ArrayList<>();
    private long master = System.currentTimeMillis();
    private boolean right = false;
    private int q = 0;

    public GameModel() {
        this.currentState = new MenuState(this);
    }

    public void switchState(GameState nextState) {
        //currentState.deactivate();
        currentState = nextState;
        //currentState.activate();
    }

    public void addPlat(Platform platform) {
        this.platList.add(platform);
    }

    public void keyPressed(int key) {
        currentState.keyPressed(key, this);
    }

    /**
     * The update function is called every iteration of the game loop.
     * it's usually used to update the games logic e.g. objects position, velocity, etc...
     */
    public void update() {
        currentState.update(this, enemyList, beamList);
    }

    public void addEnemy(int y) {
        if (System.currentTimeMillis() - master > 1000) {
            if (right) {
                //enemyList.add(q, new Dumb(true, y));
                right = false;
            } else {
                //enemyList.add(new Dumb(false, y));
                right = true;
            }
            master = System.currentTimeMillis();
        }
    }

    public void removeEnemy() {
        for (int i = 0; i < enemyList.size(); i++) {
            Enemy enemy = enemyList.get(i);
            if (enemy.getRemove() == false) {
                enemy.update(this);
            } else {
                enemyList.remove(i);
            }
        }
    }

    public void removeBeam() {
        for (int i = 0; i < beamList.size(); i++) {
            Beam beam = beamList.get(i);
            if (beam.getRemove() == false) {
                beam.update();
            } else {
                beamList.remove(i);
            }
        }
    }

    public void fire(Player player) {
        this.beamList.add(new Beam(player.getX(), player.getY(), player.getDir())); //Skicka med model i beam för att ta bort
    }

    public void draw(Graphics g) {
        currentState.draw(g, enemyList, beamList);
    }

    public void checkCollision(Player player) {
        Rectangle p = new Rectangle(player.getX(), player.getY(), 50, 50);

        //Checks player-enemy
        for (Enemy enemy : enemyList) {
            Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (rec2.intersects(p)) {
                System.out.println("Trigger");
                switchState(new MenuState(this));
            }
        }

        //Checks if beam-enemy
        for (Beam beam : beamList) {
            Rectangle rec1 = new Rectangle(beam.getX(), beam.getY(), beam.getWidth(), beam.getHeight());
            for (Enemy enemy : enemyList) {
                Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());

                if (rec1.intersects(rec2)) {
                    beam.setRemove(true);
                    enemy.setRemove(true);
                }
            }
        }

        for (Platform platform : platList) {
            Rectangle rec4 = new Rectangle(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
            if (rec4.intersects(p)) {
                player.setGround(true);
                player.setGroundLevel(platform.getY()-50);
                return;
            }
        }
        player.setGround(false);
    }
}


