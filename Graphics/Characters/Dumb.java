package Projekt.Graphics.Characters;

import javax.swing.*;
import java.awt.*;

public class Dumb extends Enemy {

    private Image image = null;

    public Dumb(boolean right, int y) {
        super(right, y);
    }

    public Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/virus1.png");
            image = i.getImage();
        }
        return image;
    }
}
