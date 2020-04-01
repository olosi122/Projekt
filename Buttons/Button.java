package Projekt.Buttons;

import Projekt.Logic.Operation.GameModel;

import javax.swing.*;
import java.awt.*;

public abstract class Button extends JComponent {

    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;
    private GameModel model;

    public Button(GameModel model,int x, int y) {
        this.x=x;
        this.y=y;
        this.model=model;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public GameModel getModel() {
        return this.model;
    }

}
