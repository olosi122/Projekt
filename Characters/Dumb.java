package Projekt.Projekt.Characters;

import Projekt.Projekt.Operation.GameModel;

import java.awt.*;

import static Projekt.Projekt.Operation.Constants.S_WIDTH;

public class Dumb extends Enemy {

    private int size = 50;
    private Color color = Color.CYAN;
    private Point point = new Point(0, 0);
    private boolean right;
    private boolean remove = false;

    public Dumb(boolean right, int y) {
        this.right = right;
        if (right) {
            this.point.x = S_WIDTH;
        } else {
            this.point.x = 0;
        }
        this.point.y = y;
    }

    public void update(GameModel model) {
        if (remove == false) {
            if (this.right) {
                this.point.x -= 1;
            } else {
                this.point.x += 1;
            }
        } else {
            model.removeEnemy(this);
        }
    }

    public void setRemove(boolean b) {
        this.remove = true;
    }

    @Override
    public boolean getRemove() {
        return this.remove;
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public int getWidth() {
        return this.size;
    }

    public int getHeight() {
        return this.size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.point.x, this.point.y, size, size);
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
