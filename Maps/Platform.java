package Projekt.Projekt.Maps;

import java.awt.*;

public class Platform {

    private int width = 100;
    private int height = 25;
    private Color color = Color.gray;
    private int pointX;
    private int pointY;

    public Platform(int x, int y) {
        this.pointX = x;
        this.pointY = y;
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
