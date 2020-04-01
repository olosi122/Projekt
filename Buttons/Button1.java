package Projekt.Buttons;

import Projekt.Logic.Operation.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static Projekt.Logic.Operation.Constants.S_HEIGHT;
import static Projekt.Logic.Operation.Constants.S_WIDTH;

public class Button1 extends JComponent {

    private String informationText;
    private Color fontColor;
    private int x;
    private int y;

    public Button1(GameModel model, int x, int y) {
        //super(model,x,y);
        this.x = x;
        this.y = y;
        informationText = "Level 1";
        fontColor = new Color(200, 198, 130);
        addMouseListener(new MouseEventHandler());
    }


    public void draw(Graphics g) {

        g.setColor(Color.green);
        g.fillRect(100, 100, 100, 100);

        //System.out.println(this.getWidth());
        //System.out.println(this.getMaximumSize());

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 30));
        g.drawString(informationText, x, y);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        /*

        g.setColor(Color.black);
        g.fillRect(getX(),getY()-50,100,100);

        g.setColor(fontColor);
        g.setFont(new Font("Monospace", Font.PLAIN, 30));
        g.drawString(informationText, getX(),getY());

         */
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }

    @Override
    public int getWidth() {
        return 100;
    }

    @Override
    public int getHeight() {
        return 100;
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
