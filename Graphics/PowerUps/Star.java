package Projekt.Graphics.PowerUps;

import Projekt.Graphics.Characters.Player;

import javax.swing.*;
import java.awt.*;

public class Star extends PowerUp {

    private Color col = Color.yellow;
    private Image image = null;

    public Star(int x, int y, Player player) {
        super(x, y, player);
    }

    public void draw(Graphics g) {
        g.setColor(col);
        g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
    }

    public Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/star.png");
            image = i.getImage();
        }
        return image;
    }

    @Override
    public void activate() {
        getPlayer().setActiveStar();
    }
}
