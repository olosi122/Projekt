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
    private int pointX;
    private int pointY;

    public Platform(int x, int y,int width, int height) {
        this.pointX = x;
        this.pointY = y;
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
        return this.pointX;
    }

    public int getY() {
        return this.pointY;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.pointX, this.pointY, this.width, this.height);
    }
}
