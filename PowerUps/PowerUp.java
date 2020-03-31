package Projekt.PowerUps;

import java.awt.*;

public abstract class PowerUp {

    private Color col = Color.yellow;
    private Point point;
    private int width = 30;
    private int height = 30;
    private boolean remove = false;

    public PowerUp(int x, int y) {
        this.point=new Point(x,y);
    }

    public abstract void draw(Graphics g);

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public void setRemove(boolean b) {
        this.remove=b;
    }

    public boolean getRemove() {
        return  this.remove;
    }

    public abstract void activate();

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
