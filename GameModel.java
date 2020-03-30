package Projekt.Projekt;

import java.awt.*;

public class GameModel {

    private GameState currentState;

    public GameModel() {
        this.currentState = new MenuState(this);
    }

    /**
     * Switch to a new state, stored in the 'state' reference.
     *
     * This will call 'deactivate' on the current state,
     * then store the new state as the current state, and finally call
     * 'activate' on the new current state.
     */
    public void switchState(GameState nextState) {
        currentState.deactivate();
        currentState = nextState;
        currentState.activate();
    }

    /**
     * Delegates the keyPress from GamePanel to the current state
     * @param key
     */
    public void keyPressed(int key) {
        currentState.keyPressed(key);
    }

    /**
     * The update function is called every iteration of the game loop.
     * it's usually used to update the games logic e.g. objects position, velocity, etc...
     */
    public void update() {
        currentState.update();
    }

    /**
     * @param g Graphics object passed from GamePanel
     *          This function delegates drawing from the GamePanel to the current state
     */
    public void draw(Graphics g) {
        currentState.draw(g);
    }
}
