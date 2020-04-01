package Projekt.Graphics.Characters;

/**
 * Beam är en egen klass som beskriver skotten som spelaren kan skjutagenom att tryck på space, i rätt "state".
 * När spelaren skjuter så skapas en ny instans av klassen som lagras i en Arraylist i GameModel.
 * Det viktiga här att att alla skotten ska hanteras likadant, med några skillnader i initiallt tillstånd.
 * Det som tas in i funktionen är vart skottet avfyras och i vilken riktining. Genom att hållar reda på dessa
 * två (eller tre beroende på hur man ser det) kan man hantera alla skotten med samma klassfunktioner.
 */

import java.awt.*;

import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Beam {

    private Color color = Color.RED;
    private int width = 20;
    private int height = 10;
    private boolean dir;
    private Point point = new Point(0,0);
    private boolean remove = false;

    public Beam(int x, int y, boolean dir) {
        this.point.x = x;
        this.point.y = y;
        this.dir = dir;
    }

    public void update() {
        if (dir == true) {
            if (point.x == S_WIDTH) {
                this.setRemove(true);
            }
            this.point.x += 3;
        } else {
            if (point.x == 0) {
                this.setRemove(true);
            }
            this.point.x -= 3;
        }
    }

    public boolean getRemove() {
        return this.remove;
    }

    public void draw(Graphics g) {

        g.setColor(this.color);
        g.fillRect(this.point.x, this.point.y, width, height);
    }

    public int getX() {
        return this.point.x;
    }

    public int getY() {
        return this.point.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setRemove(boolean b) {
        this.remove = b;
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
