package Projekt.Projekt;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Dumb;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.Maps.Level;
import Projekt.Projekt.States.GameState;
import Projekt.Projekt.States.Level1;
import Projekt.Projekt.States.MenuState;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private long master = System.currentTimeMillis();
    private boolean right = false;

    public GameModel() {
        this.currentState = new MenuState(this);
    }

    /**
     * Switch to a new state, stored in the 'state' reference.
     * <p>
     * This will call 'deactivate' on the current state,
     * then store the new state as the current state, and finally call
     * 'activate' on the new current state.
     */
    public void switchState(GameState nextState) {
        //currentState.deactivate();
        currentState = nextState;
        //currentState.activate();
    }

    /**
     * Delegates the keyPress from GamePanel to the current state
     *
     * @param key
     */
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
                enemyList.add(new Dumb(true,y));
                right=false;
            } else {
                enemyList.add(new Dumb(false,y));
                right=true;
            }
            master = System.currentTimeMillis();
        }
    }

    public void addBeam() {
        this.beamList.add(new Beam(currentState.getX(), currentState.getY(), currentState.getDir()));
    }


    /**
     * @param g Graphics object passed from GamePanel
     *          This function delegates drawing from the GamePanel to the current state
     */
    public void draw(Graphics g) {
        currentState.draw(g, enemyList, beamList);
    }

    public void checkCollision() {
        Iterator itrb = beamList.iterator();
        Iterator itre = enemyList.iterator();
        while (itrb.hasNext()) {
            Beam beam = (Beam) itrb.next();
            while (itre.hasNext()) {
                Enemy enemy = (Enemy) itre.next();
                Rectangle rec1 = new Rectangle(beam.getX(), beam.getY(), beam.getWidth(), beam.getHight());
                Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHight());
                Rectangle player = new Rectangle(currentState.getX(),currentState.getY(),50,50);
                if (rec2.intersects(player)) {
                    //GameOver
                    switchState(new MenuState(this));
                }
                if (rec1.intersects(rec2)) {
                    itrb.remove();
                    itre.remove();
                }
            }
        }
    }
}
