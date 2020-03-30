package Projekt.Projekt.Characters;

import Projekt.Projekt.Operation.GameModel;
import Projekt.Projekt.States.Level1;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Projekt.Projekt.Operation.Constants.S_HEIGHT;

public class Player {
    private Point point;
    private long start = 0;
    private boolean jump = false;
    private double x = 0;
    private boolean dir = true;

    public Player() {
        this.point = new Point(500, S_HEIGHT - 100);
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(point.x, point.y, 50, 50);
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public boolean getDir() {
        return this.dir;
    }

    public void cancelJump() {
        this.jump=false;
        this.x=0;
    }

    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_RIGHT) {
            this.dir = true;
            this.point.x += 10;
        } else if (key == KeyEvent.VK_LEFT) {
            this.dir = false;
            this.point.x -= 10;
        } else if (key == KeyEvent.VK_UP) {
            this.start = System.currentTimeMillis();
            this.jump = true;
        } else if (key == KeyEvent.VK_SPACE) {
            model.addBeam(this);
        }
    }

    public void update() {
        if (jump == true) {
            if (dir==true) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x + x);
                x += 0.1;
            } else if (dir==false) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x - x);
                x += 0.1;
            }

            if (point.y>S_HEIGHT-100) {
                this.jump=false;
                x=0;
                point.y=S_HEIGHT-100;
            }
        }
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
