package Projekt.Projekt.Characters;

import java.awt.*;

public class Dumb extends Enemy {

    private int size = 50;
    private Color color = Color.CYAN;
    private Point point = new Point(0,0);
    private boolean right;

    public Dumb(boolean right, int y) {
        this.right=right;
        if (right) {
            this.point.x = 1600;
        } else {
            this.point.x = 0;
        }
        this.point.y=y;
    }

    public void update() {
        if (this.right) {
            this.point.x -= 1;
        } else {
            this.point.x += 1;
        }
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

    public int getHight() {
        return this.size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.point.x,this.point.y, size,size);
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
