package Projekt.Projekt;

import java.awt.*;

import static Projekt.Projekt.Constants.S_WIDTH;
import static Projekt.Projekt.Constants.S_HEIGHT;

public abstract class GameState {

    protected GameModel model;

    public GameState(GameModel model) {
        this.model = model;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract void keyPressed(int key);

    public void drawBg(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }

    public void activate() { ; }

    public void deactivate() { ; }
}

