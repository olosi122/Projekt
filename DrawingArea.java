package Projekt.Projekt;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingArea extends JPanel {

    private ArrayList<Square> shapeList = new ArrayList<>();

    public DrawingArea() {
        Square sq1 = new Square(10,10);
        Square sq2 = new Square(10,100);

        shapeList.add(sq1);
        shapeList.add(sq2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //int centerX = getWidth() / 2;
        //int centerY = getHeight() / 2;
        for (Square sq : shapeList) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(sq.getAngle(), sq.getPointX(), sq.getPointY());
            g2d.setColor(Color.black);
            g2d.fillRect(sq.getPointX(), sq.getPointY(), 40, 40);
            this.repaint();
        }
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    }
}
