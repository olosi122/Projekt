package Projekt.Characters;

import Projekt.Operation.GameModel;

import java.awt.*;

import static Projekt.Operation.Constants.S_WIDTH;

public class Dumb extends Enemy {


    private Color color = Color.CYAN;

    public Dumb(boolean right, int y) {
        super(right,y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.getX(), this.getY(), getSize(), getSize());
    }
}
