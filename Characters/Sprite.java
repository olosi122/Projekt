package Projekt.Characters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    private static int width;
    private static int height;
    private static BufferedImage image = null;

    public Sprite() {

    }

    private static BufferedImage getImage() throws IOException {
        if (image == null) {
            ImageIO.read(new File("sprites/virus1.png"));
        }
        return image;
    }
}
