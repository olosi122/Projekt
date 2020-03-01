package Projekt.Projekt;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JComponent implements KeyListener, MouseListener {

    private int pointX = 1; // distance
    private int pointY = 1; // distance
    private double angle = 0;

    public Square(int pointX, int pointY) {
        addKeyListener(this);
        this.setFocusable(true);
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getAngle() {
        return this.angle;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void updateYourself() {
        pointX += 10;
        angle += 0.5;
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.updateYourself();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.updateYourself();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
