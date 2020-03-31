package Projekt.Operation;

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

    public void update() {
        if (System.currentTimeMillis()-master>1000) {
            time+=1;
            System.out.println(time);
            //om en viss tid så vinner man banan
            master=System.currentTimeMillis();
        }
    }
}
