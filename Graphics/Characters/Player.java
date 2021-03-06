package Projekt.Graphics.Characters;

/**
 * En stor player-klass som hanerar allting relaterat till spelaren. Här hittar vi många olika klassvariabler som
 * används för att kunna skilja på de olika situationerna som spelaren befinner sig i. Dessa används i logiken
 * inuti funktionerna. Ytterst många setters och getters som används för att kunna kontrollera de privata variablerna
 * i en komplex struktur som denna.
 * <p>
 * Lite unikt för den här är haneringen av knapptryck som registreras på GamePanel och efter att ha passerat PlayState
 * (GameState är abstract) så hanteras mycket av spelarens kontroll av den här klassen.
 */

import Projekt.Logic.Operation.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Player {

    private Point point;
    private boolean jump = false;
    private double x = 1;
    private boolean dir = true;
    private boolean ground;
    private boolean jumping = false;
    private int groundLevel;
    private int width = 75;
    private int height = 75;
    private static Image image = null;
    private boolean activeStar = false;
    private boolean activeMushroom = false;
    private long master;

    public Player() {
        this.point = new Point(500, S_HEIGHT - 150);
    }

    public void draw(Graphics g) {
        g.drawImage(getImage(), point.x, point.y, width, height, null);
    }

    private static Image getImage() {
        if (image == null) {
            ImageIcon i = new ImageIcon("sprites/playersprite.png");
            image = i.getImage();
        }
        return image;
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public boolean getDir() {
        return this.dir;
    }

    public void keyPressed(int key, GameModel model) {

        if (key == KeyEvent.VK_RIGHT) {
            this.dir = true;
            if (this.point.x < S_WIDTH - 60) {
                this.point.x += 10;
            }
        } else if (key == KeyEvent.VK_LEFT) {
            this.dir = false;
            if (this.point.x > 0) {
                this.point.x -= 10;
            }
        } else if (key == KeyEvent.VK_UP) {
            this.jump = true;
        } else if (key == KeyEvent.VK_SPACE) {
            model.fire(this);
        }
    }

    public void setGround(boolean b) {
        this.ground = b;
    }

    public void update() {

        this.checkPower();

        if ((ground == false && jump == false && jumping == false) || ground == false && jump == true && jumping == false) {
            point.y = point.y + 1;
        } else if (ground && jump && jumping) {
            jump = false;
            jumping = false;
            x = 0;
            this.point.y = groundLevel;
        } else if (ground == false && jump == true && jumping) {
            if (dir == true) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x + x);
                x += 0.1;
            } else if (dir == false) {
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                point.x = (int) (point.x - x);
                x += 0.1;
            }
        } else if (ground == true && jump == true && jumping == false) {
            point.y = point.y - 1;
            jumping = true;
        }
    }

    private void checkPower() {
        if (activeStar == true && (System.currentTimeMillis() - master > 10000)) {
            this.activeStar = false;
        }
    }

    public void setGroundLevel(int y) {
        this.groundLevel = y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getActiveStar() {
        return this.activeStar;
    }

    public void setActiveStar(boolean b) {
        if (b) {
            this.master = System.currentTimeMillis();
        }
        this.activeStar = b;
    }

    public boolean getActiveMushroom() {
        return this.activeMushroom;
    }

    public void setActiveMushroom(boolean b) {
        this.activeMushroom = b;
    }


    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

