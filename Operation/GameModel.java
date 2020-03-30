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
                enemyList.add(q, new Dumb(true, y));
                right = false;
            } else {
                enemyList.add(new Dumb(false, y));
                right = true;
            }
            master = System.currentTimeMillis();
        }
    }

    public void addBeam(Player player) {
        this.beamList.add(new Beam(player.getX(), player.getY(), player.getDir())); //Skicka med model i beam för att ta bort
    }

    public void draw(Graphics g) {
        currentState.draw(g, enemyList, beamList);
    }

    public void checkCollision() {
        Iterator<Beam> itrb = beamList.iterator();
        Iterator<Enemy> itre = enemyList.iterator();
        //Jag låser thred och tittar bara på första skottet
        for (Enemy enemy:enemyList) {
        //while (itre.hasNext()) {
            //Beam beam = (Beam) itrb.next();
            //Enemy enemy = (Enemy) itre.next();
            //System.out.println(beam);
            System.out.println(enemy);
            //Rectangle rec1 = new Rectangle(beam.getX(), beam.getY(), beam.getWidth(), beam.getHight());
            Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHight());
            System.out.println(enemy.getX());
            System.out.println(enemy.getY());
            Rectangle player = new Rectangle(currentState.getX(), currentState.getY(), 50, 50);

            if (rec2.intersects(player)) {
                System.out.println("Trigger");
                switchState(new MenuState(this));
            }
            //if (rec1.intersects(rec2)) {
            //   itrb.remove();
            // itre.remove();
        }
    }
}
        /*
        Iterator iterp = platList.iterator();
        while (iterp.hasNext()) {
            Platform platform = (Platform) iterp.next();
            Rectangle rec4 = new Rectangle(platform.getX(), platform.getY(), platform.getWidth(), 1);
            if (player.intersects(rec4) && currentState.getY() + 50 == platform.getY()) {

            }

         */


