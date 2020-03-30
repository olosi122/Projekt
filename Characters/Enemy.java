package Projekt.Projekt.Characters;

import java.awt.*;

public abstract class Enemy {

    public Enemy() {
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract int getX();

    public abstract int getY();

    public abstract int getWidth();

    public abstract int getHight();

}
