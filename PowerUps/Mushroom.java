package Projekt.PowerUps;

import java.awt.*;

public class Mushroom extends PowerUp {
    private Color col = Color.red;

    public Mushroom(int x, int y) {
        super(x,y);
    }

    public void draw(Graphics g) {
        g.setColor(col);
        g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void activate() {
        //do something
    }
}