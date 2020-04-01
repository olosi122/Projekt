package Projekt.Graphics.PowerUps;

import Projekt.Graphics.Characters.Player;

import java.awt.*;

public class Mushroom extends PowerUp {
    private Color col = Color.red;

    public Mushroom(int x, int y, Player player) {
        super(x, y, player);
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