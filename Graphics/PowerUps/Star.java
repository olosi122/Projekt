package Projekt.Graphics.PowerUps;

/**
 * Det enda underklasserna till Powerups behöver hanter är dess individuella grafik och aktivering/nytta.
 */

import Projekt.Graphics.Characters.Player;

import javax.swing.*;
import java.awt.*;

public class Star extends PowerUp {

    private Image image = null;

    public Star(int x, int y, Player player) {
        super(x, y, player);
    }

    @Override
    public Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/star.png");
            image = i.getImage();
        }
        return image;
    }

    @Override
    public void activate() {
        getPlayer().setActiveStar(true);
    }
}
