package Projekt.Characters;

import Projekt.Operation.GameModel;

import java.awt.*;

import static Projekt.Operation.Constants.S_WIDTH;

public class Beam {

    private Color color = Color.RED;
    private int width = 20;
    private int height = 10;
    private boolean dir;
    private int point_x = 0;
    private int point_y = 0;
    private boolean remove = false;
    //private Point point;

    public Beam(int x, int y, boolean dir) {
        this.point_x = x;
        this.point_y = y;
        this.dir = dir;
    }

    public void update() {
        if (dir == true) {
            if (point_x == S_WIDTH) {
                this.setRemove(true);
            }
            this.point_x += 1;
        } else {
            if (point_x == 0) {
                this.setRemove(true);
            }
            this.point_x -= 1;
        }
    }

    public boolean getRemove() {
        return this.remove;
    }

    public void draw(Graphics g) {

        g.setColor(this.color);
        g.fillRect(this.point_x, this.point_y, width, height);
    }

    public int getX() {
        return this.point_x;
    }

    public int getY() {
        return this.point_y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setRemove(boolean b) {
        this.remove = b;
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
