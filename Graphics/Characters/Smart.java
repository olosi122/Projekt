package Projekt.Graphics.Characters;

/**
 * Smart är den andra underklassen till Enemy och har en ytterligare funktion som det överskuggar.
 * Funktionen update i det här fallet körs först i parent-klassen (som justerar alla fienders förändring i x-led
 * över spelets gång) med ett tillägg med att sakta målsöka spelarens y-kordinater.
 */

import Projekt.Logic.Operation.GameModel;

import javax.swing.*;
import java.awt.*;

public class Smart extends Enemy {

    private Player player;
    private Image image = null;

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

    public Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/virus2.png");
            image = i.getImage();
        }
        return image;
    }
}
