package Projekt.Graphics.PowerUps;

import Projekt.Graphics.Characters.Player;

import javax.swing.*;
import java.awt.*;

public class Mushroom extends PowerUp {
    private Color col = Color.red;
    private Image image = null;

    public Mushroom(int x, int y, Player player) {
        super(x, y, player);
    }

    public void draw(Graphics g) {
        g.drawImage(getImage(),getX(),getY(),getWidth(),getHeight(),null);
    }

    public Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/mushroom.png");
            image = i.getImage();
        }
        return image;
    }

    @Override
    public void activate() {
        //do something
    }
}