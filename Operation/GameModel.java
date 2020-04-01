package Projekt.Operation;

import Projekt.Characters.Beam;
import Projekt.Characters.Dumb;
import Projekt.Characters.Enemy;
import Projekt.Characters.Player;
import Projekt.Characters.Platform;
import Projekt.PowerUps.PowerUp;
import Projekt.PowerUps.Star;
import Projekt.States.GameState;
import Projekt.States.MenuState;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private ArrayList<Platform> platList = new ArrayList<>();
    private ArrayList<PowerUp> powerList = new ArrayList<>();


    public GameModel() {
        this.currentState = new MenuState(this);
    }

    public void switchState(GameState nextState) {
        currentState = nextState;
    }

    public void addPlat(Platform platform) {
        this.platList.add(platform);
    }

    public void addPower(PowerUp power) {
        this.powerList.add(power);
    }

    public void keyPressed(int key) {
        currentState.keyPressed(key, this);
    }

    public void update() {
        currentState.update(this, enemyList, beamList);
    }

    public void addEnemy(Enemy enemy) {
        //currentState.addEnemy(y);
        enemyList.add(enemy);
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

    public void removePower() {
        for (int i = 0; i < powerList.size(); i++) {
            PowerUp power = powerList.get(i);
            if (power.getRemove() == true) {
                powerList.remove(i);
            }
        }
    }

    public void fire(Player player) {
        this.beamList.add(new Beam(player.getX(), player.getY(), player.getDir())); //Skicka med model i beam för att ta bort
    }

    public void draw(Graphics g) throws IOException {
        currentState.draw(g, enemyList, beamList, platList, powerList);
    }

    public void checkCollision(Player player) {
        Rectangle p = new Rectangle(player.getX(), player.getY(), 50, 50);

        for (Enemy enemy : enemyList) {
            Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (rec2.intersects(p)) {
                this.enemyList = new ArrayList<>();
                this.beamList = new ArrayList<>();
                this.platList = new ArrayList<>();
                switchState(new MenuState(this));
            }
        }

        for (PowerUp power : powerList) {
            Rectangle rec5 = new Rectangle(power.getX(), power.getY(), power.getWidth(), power.getHeight());
            if (rec5.intersects(p)) {
                System.out.println("träff");
                power.activate();
                power.setRemove(true);
            }
        }

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
                player.setGroundLevel(platform.getY() - 50);
                return;
            }
        }
        player.setGround(false);
    }

    public void clearLevel() {
       this.enemyList = new ArrayList<>();
        this.beamList = new ArrayList<>();
        this.platList = new ArrayList<>();
        this.powerList = new ArrayList<>();
    }
}


