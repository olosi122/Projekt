package Projekt.Projekt.Characters;

import java.awt.*;

public class Beam {

    private Color color=Color.RED;
    private int width = 20;
    private int hight = 10;
    private boolean dir;
    private Point point;

    public Beam(int x, int y, boolean dir) {
        this.point.x=x;
        this.point.y=y;
        this.dir=dir;

    }

    public void update() {
        this.point.x -=1;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.point.x,this.point.y, width,hight);
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
