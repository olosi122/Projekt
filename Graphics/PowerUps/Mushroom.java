package Projekt.Graphics.PowerUps;

/**
 * Det enda underklasserna till Powerups behöver hanter är dess individuella grafik och aktivering/nytta.
 */

import Projekt.Graphics.Characters.Player;

import javax.swing.*;
import java.awt.*;

public class Mushroom extends PowerUp {

    private Image image = null;

    public Mushroom(int x, int y, Player player) {
        super(x, y, player);
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
        getPlayer().setActiveMushroom(true);
    }
}