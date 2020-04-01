package Projekt.Graphics.Characters;

/**
 * Dumb är en underklass till Enemy, där den mesta av funktionaliteten ligger i Enenmy ty den är gemensam för de båda
 * fienderna. I dett fall kan alla klassvariabler ligga i parent-klassen förutom den unika bilden för just Dumb.
 * Den kallas Dumb ty den inte följer spelarens ändringar i Y-led.
 */

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
