package Projekt.Graphics.Characters;

/**
 * Platform är enkel klass som endast genom Java.awt:s egna geometri ritar ut platformar för spelaren att stå på.
 * Även här finner vi många getters vilket behövs då vi undersöker kollistionen med spelaren och alla plattformar
 * kontinuerligt under spelets gång.
 */

import java.awt.*;

public class Platform {

    private int width;
    private int height;
    private Color color = Color.gray;
    private Point point = new Point(0,0);

    public Platform(int x, int y,int width, int height) {
        this.point.x = x;
        this.point.y = y;
        this.width = width;
        this.height = height;
    }

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

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.point.x, this.point.y, this.width, this.height);
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
