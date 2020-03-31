package Projekt.Projekt.Operation;

public class Timer {

    private int time = 0;
    private long master;

    public Timer() {
        this.master=System.currentTimeMillis();
    }

    public void draw() {

    }

    public void update() {
        if (System.currentTimeMillis()-master>1000) {
            time+=1;
            System.out.println(time);
            master=System.currentTimeMillis();
        }
    }
}
