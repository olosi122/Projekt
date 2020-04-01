package Projekt.Graphics.PowerUps;

/**
 * Parent-klassen till alla Powerups. Största funktionen är att dra ner på mängden kod som behövs skrivas för alla
 * Powerups, ty det mesta är getters och setters för att hantera kollisionerna med spelaren och dess borttagning från
 * kartan.
 */

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

    public void draw(Graphics g) {
            g.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
        }

    public abstract Image getImage();

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
