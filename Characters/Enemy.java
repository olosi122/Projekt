package Projekt.Characters;

import Projekt.Operation.GameModel;

import java.awt.*;

public abstract class Enemy {

    public Enemy() {
    }

    public abstract void update(GameModel model);

    public abstract void draw(Graphics g);

    public abstract int getX();

    public abstract int getY();

    public abstract int getWidth();

    public abstract int getHeight();

    public abstract void setRemove(boolean b);

    public abstract boolean getRemove();
}
