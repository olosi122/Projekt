package Projekt.Graphics.PowerUps;

import Projekt.Graphics.Characters.Player;

import java.awt.*;

public abstract class PowerUp {

    private Point point;
    private int width = 30;
    private int height = 30;
    private boolean remove = false;
    private Player player;

    public PowerUp(int x, int y, Player player) {
        this.point=new Point(x,y);
        this.player=player;
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

    public Player getPlayer() {
        return player;
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
