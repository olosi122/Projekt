package Projekt.Buttons;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Operation.GameModel;
import Projekt.PowerUps.PowerUp;
import Projekt.States.Level1;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import static Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Operation.Constants.S_WIDTH;

public class Button1 extends JComponent {

    private String informationText;
    private Color fontColor;
    private int x;
    private int y;

    public Button1(GameModel model, int x, int y) {
        //super(model,x,y);
        this.x=x;
        this.y=y;
        informationText = "Level 1";
        fontColor = new Color(200, 198, 130);
        addMouseListener(new MouseEventHandler());
    }

    /*
    public void draw(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(getX(),getY()-50,100,100);

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 30));
        g.drawString(informationText, getX(),getY());
    }

     */

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.green);
        g.fillRect(100,100,100,100);

        //System.out.println(this.getWidth());
        //System.out.println(this.getMaximumSize());

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 30));
        g.drawString(informationText, x,y);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,5));
    }

    @Override
    public int getWidth() {
        return S_WIDTH;
    }

    @Override
    public int getHeight() {
        return S_HEIGHT;
    }

    @Override
    public Dimension getMaximumSize() {
        return (new Dimension(S_WIDTH, S_HEIGHT));
    }

    private class MouseEventHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("hej");
            //getModel().switchState(new Level1(getModel()));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ;
        }
    }
}
