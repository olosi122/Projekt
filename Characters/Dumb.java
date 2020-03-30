package Projekt.Projekt.Characters;

import java.awt.*;

public class Dumb extends Enemy {

    private int size = 50;
    private Color color = Color.CYAN;
    private Point point = new Point(0,0);

    public Dumb(int y) {
        this.point.x=0;
        this.point.y=y;
    }

    public void update() {
        this.point.x +=1;
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
