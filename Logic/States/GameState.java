package Projekt.Logic.States;

/**
 * GameState är en övergipande klass om innfattar alla States som spelet har. Den är abstrakt och fyller främst
 * en funktion för att enkelt kunna referera till tillhörande GameModel i alla States, samt att ge ett namn
 * till en struktur som valbara States kan anta (t.ex. alla states som currentState i GameModel kan anta).
 */

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Platform;
import Projekt.Logic.Operation.GameModel;
import Projekt.Graphics.PowerUps.PowerUp;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

import static Projekt.Logic.Operation.Constants.S_WIDTH;
import static Projekt.Logic.Operation.Constants.S_HEIGHT;

public abstract class GameState {

    private GameModel model;

    public GameState(GameModel model) {
        this.model = model;
    }

    public abstract void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) throws IOException, ClassNotFoundException;

    public abstract void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList, ArrayList<PowerUp> powerList) throws IOException, ClassNotFoundException;

    public abstract void keyPressed(int key,GameModel model) throws IOException, ClassNotFoundException;

    public void drawBg(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, S_WIDTH, S_HEIGHT);
    }

    public GameModel getModel() {
        return this.model;
    }

    public abstract void getTime() throws IOException, ClassNotFoundException;
}

