package Projekt.Characters;

import Projekt.Operation.GameModel;

import java.awt.*;

public class Smart extends Enemy {

    private Player player;

    public Smart(boolean right, int y, Player player) {
        super(right, y);
        this.player = player;
    }

    @Override
    public void update(GameModel model) {
        super.update(model);
        if (player.getY() > getY()) {
            setY(1);
        } else {
            setY(-1);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(this.getX(), this.getY(), getSize(), getSize());
    }
}
