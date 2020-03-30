package Projekt.Projekt.Characters;

import java.awt.*;

public class Beam {

    private Color color = Color.RED;
    private int width = 20;
    private int hight = 10;
    private boolean dir;
    private int point_x=0;
    private int point_y=0;
    //private Point point;

    public Beam(int x, int y, boolean dir) {
        this.point_x = x;
        this.point_y = y;
        this.dir = dir;

    }

    public void update() {
        if (dir==true) {
            this.point_x += 1;
            //Until remove from list
        } else {
            this.point_x -= 1;
            //Until remove from list
        }
    }

    public void draw(Graphics g) {

        g.setColor(this.color);
        g.fillRect(this.point_x, this.point_y, width, hight);
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

    public int getHight() {
        return this.hight;
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
