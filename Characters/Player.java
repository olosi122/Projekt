package Projekt.Projekt.Characters;

import Projekt.Projekt.Operation.GameModel;
import Projekt.Projekt.States.Level1;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Projekt.Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Projekt.Operation.Constants.S_WIDTH;

public class Player {
    private Point point;
    private boolean jump = false;
    private double x = 1;
    private boolean dir = true;
    private boolean ground;
    private boolean jumping = false;
    private int groundLevel;

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

    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_RIGHT) {
            this.dir = true;
            if (this.point.x < S_WIDTH - 60) {
                this.point.x += 10;
            }
        } else if (key == KeyEvent.VK_LEFT) {
            this.dir = false;
            if (this.point.x > 0) {
                this.point.x -= 10;
            }
        } else if (key == KeyEvent.VK_UP) {
            this.jump = true;
        } else if (key == KeyEvent.VK_SPACE) {
            model.fire(this);
        }
    }

    public void setGround(boolean b) {
        this.ground = b;
    }

    public void update() {
        if ((ground == false && jump == false && jumping==false) || ground == false && jump == true && jumping==false) {
            point.y = point.y + 1;
        } else if (ground && jump && jumping) {
            jump = false;
            jumping = false;
            x=0;
            this.point.y=groundLevel;
        } else if (ground == false && jump == true && jumping) {
            if (dir == true) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x + x);
                x += 0.1;
            } else if (dir == false) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x - x);
                x += 0.1;
            }
        } else if (ground == true && jump == true && jumping == false) {
            point.y = point.y - 1;
            jumping = true;
        }
    }

    public void setGroundLevel(int y) {
        this.groundLevel=y;
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

