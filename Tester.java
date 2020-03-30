package Projekt.Projekt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Projekt.Projekt.Constants.S_HEIGHT;
import static Projekt.Projekt.Constants.S_WIDTH;

public class Tester {
    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point position;
    private BufferedImage hBanana;
    private BufferedImage basket;

    public Tester() {
        position = new Point(0, 0);

        //hBanana  = loadImage("h-banana.png");
        //basket   = loadImage("Basket.png");
    }

    public void delegate(Graphics g) {
        if (g != null)
            draw(g);
        else
            update();
    }

    private void draw(Graphics g){
        if (position.x < S_WIDTH && position.y < S_HEIGHT) {
            testDraw(g);
        }
    }

    private void update(){
        /* ==== Used for testing ====*/
        position.x += 1;
        position.y += 1;
    }

    /* ====== USED FOR TESTING ====== */
    private void testDraw(Graphics g) {
        g.drawImage(basket, position.x, position.y, 80, 80, null);

        g.setColor(Color.BLUE);
        g.drawString("D-9", position.x + 20, position.y + 45);

        g.drawImage(hBanana, position.x + 200, position.y + 200, 100, 100, null);
    }

    /* ====== USED FOR TESTING ======
    this is not a good way for loading more than one image.
    See the course web page for that information.
    */
    private BufferedImage loadImage(String imgPath) {
        try {
            return ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
