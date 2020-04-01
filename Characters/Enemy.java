package Projekt.Characters;

import Projekt.Operation.GameModel;

import java.awt.*;

import static Projekt.Operation.Constants.S_WIDTH;

public abstract class Enemy {

    private boolean remove = false;
    private int size = 50;
    private boolean right;
    private Dumb.Point point = new Dumb.Point(0, 0);

    public Enemy(boolean right, int y) {
        this.right = right;
        if (right) {
            this.point.x = S_WIDTH;
        } else {
            this.point.x = 0;
        }
        this.point.y = y;
    }

    public void update(GameModel model) {
        if (this.right) {
            this.point.x -= 1;
        } else {
            this.point.x += 1;
        }
    }

    public abstract void draw(Graphics g);

    public void setRemove(boolean b) {
        this.remove = true;
    }

    public boolean getRemove() {
        return this.remove;
    }

    public int getX() {
        return this.point.x;
    }


    public int getY() {
        return this.point.y;
    }

    public void setY(int i) {
        this.point.y+=i;
    }

    public int getWidth() {
        return this.size;
    }

    public int getHeight() {
        return this.size;
    }

    public void setRight(boolean r) {
        this.right=r;
    }

    public boolean getRight() {
        return this.right;
    }

    public int getSize() {
        return size;
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
