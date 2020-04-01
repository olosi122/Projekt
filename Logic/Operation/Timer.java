package Projekt.Logic.Operation;

/**
 * Detta är en tajmer-klass som gjorts externt från alla klasser ty den används på många ställen.
 * Genom att sätta en punkt i tiden med hjälp av klassvariabeln "master" kan man enkelt kunna få en
 * tickande klock i sekunder. Denna används för att mäta tiden på Level1 och Level2 samt att
 * sätta Highscore som räknas i tid.
 */

import java.awt.*;

public class Timer {

    private int time = 0;
    private long master;

    public Timer() {
        this.master=System.currentTimeMillis();
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.setFont(new Font("Times New Roman", Font.BOLD, 40));
        g.drawString("Time: " + time, 25,50);
    }

    public int getTime() {
        return time;
    }

    public void update() {
        if (System.currentTimeMillis()-master>1000) {
            time+=1;
            master=System.currentTimeMillis();
        }
    }
}
