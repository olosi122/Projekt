package Projekt.Operation;

import Projekt.Characters.Beam;
import Projekt.Characters.Dumb;
import Projekt.Characters.Enemy;
import Projekt.Characters.Player;
import Projekt.Characters.Platform;
import Projekt.States.GameState;
import Projekt.States.MenuState;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private ArrayList<Platform> platList = new ArrayList<>();
    private long master = System.currentTimeMillis();
    private boolean right = false;
    private int q = 0;
    private int intervall = 1000;

    public GameModel() {
        this.currentState = new MenuState(this);
    }

    public void switchState(GameState nextState) {
        currentState = nextState;
    }

    public void addPlat(Platform platform) {
        this.platList.add(platform);
    }

    public void keyPressed(int key) {
        currentState.keyPressed(key, this);
    }

    public void update() {
        currentState.update(this, enemyList, beamList);
    }

    public void addEnemy(int y) {
        //currentState.addEnemy(y);
        if (System.currentTimeMillis() - master > intervall) {
            this.intervall-=10;
            if (right) {
                enemyList.add(q, new Dumb(true, y));
                right = false;
            } else {
                enemyList.add(new Dumb(false, y));
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
        currentState.draw(g, enemyList, beamList,platList);
    }

    public void checkCollision(Player player) {
        Rectangle p = new Rectangle(player.getX(), player.getY(), 50, 50);

        for (Enemy enemy : enemyList) {
            Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (rec2.intersects(p)) {
                this.enemyList= new ArrayList<>();
                this.beamList= new ArrayList<>();
                this.platList=new ArrayList<>();
                switchState(new MenuState(this));
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
                player.setGroundLevel(platform.getY()-50);
                return;
            }
        }
        player.setGround(false);
    }
}


