package Projekt.Projekt.States;

import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.GameModel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Projekt.Constants.S_HEIGHT;
import static Projekt.Projekt.Constants.S_WIDTH;

public class Level1 extends GameState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;
    private Point point;
    private long start = 0;
    private boolean jump = false;
    private double x = 0;
    private boolean dir = true;

    public Level1(GameModel model) {
        super(model);
        informationText = "Press Escape To Return To The Menu";
        bgColor = new Color(78, 87, 100);
        fontColor = new Color(123, 178, 116);
        this.point = new Point(500, S_HEIGHT - 100);
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies) {
        drawBg(g, bgColor);

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 20));
        g.drawString(informationText, (S_WIDTH / 2) - 200, S_HEIGHT / 2);

        g.setColor(Color.black);
        g.fillOval(point.x, point.y, 50, 50);

        for (Enemy enemy: enemies) {
        enemy.draw(g);
        }
    }

    @Override
    public void keyPressed(int key) {
        System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i PlayState");
        //System.out.println(key); //an integer connected with every keybord button

        if (key == KeyEvent.VK_ESCAPE) {
            model.switchState(new MenuState(model));
        } else if (key == KeyEvent.VK_RIGHT) {
            this.dir=true;
            this.point.x += 10;
        } else if (key == KeyEvent.VK_LEFT) {
            this.dir=false;
            this.point.x -= 10;
        } else if (key == KeyEvent.VK_UP) {
            this.start = System.currentTimeMillis();
            this.jump = true;
        } //else if (key == KeyEvent.VK_DOWN && point.y < S_HEIGHT - 100) {
            //Will not do anything
            //Kollision with platforms for stop falling
            //then cant jump/drop through them
        else if (key == KeyEvent.VK_SPACE) {
            //Shoot
        }
    }



    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies) {
        //Use this one when jumping, cause it will need to carry out for a while during which other movements can be made
        //tester.delegate(null);
        model.addEnemy(point.y);
        for (Enemy enemy: enemies) {
            enemy.update();
        }
        if (jump == true) {
            if (dir==true) {
                //long x = (System.currentTimeMillis() - start)/1000;
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                System.out.println(x);
                point.x = (int) (point.x + x);
                x += 0.1;
            } else if (dir==false) {
                //long x = (System.currentTimeMillis() - start)/1000;
                point.y = (int) (point.y - (-Math.pow(x, 2.0) + (5 * x)));
                System.out.println(x);
                point.x = (int) (point.x - x);
                x += 0.1;
            }

            /**
             * Needs reworking later
             */

            if (point.y>S_HEIGHT-100) {
                this.jump=false;
                x=0;
                System.out.println(x);
                point.y=S_HEIGHT-100;
            }
        }
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

