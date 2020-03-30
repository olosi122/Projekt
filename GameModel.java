package Projekt.Projekt;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Dumb;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.States.GameState;
import Projekt.Projekt.States.MenuState;

import java.awt.*;
import java.util.ArrayList;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private long master = System.currentTimeMillis();

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
     * @param key
     */
    public void keyPressed(int key) {
        currentState.keyPressed(key,this);
    }

    /**
     * The update function is called every iteration of the game loop.
     * it's usually used to update the games logic e.g. objects position, velocity, etc...
     */
    public void update() {
        currentState.update(this, enemyList);
    }

    public void addEnemy(int y) {
        if (System.currentTimeMillis() - master > 1000) {
            enemyList.add(new Dumb(y));
            master = System.currentTimeMillis();
        }
    }

    public void addBeam(int x, int y) {
        this.beamList.add(new Beam(currentState.getX(),currentState.getY(),currentState.getDir()));
    }


    /**
     * @param g Graphics object passed from GamePanel
     *          This function delegates drawing from the GamePanel to the current state
     */
    public void draw(Graphics g) {
        currentState.draw(g, enemyList);
    }
}
