package Projekt.Projekt.States;

import Projekt.Projekt.Characters.Beam;
import Projekt.Projekt.Characters.Enemy;
import Projekt.Projekt.Characters.Player;
import Projekt.Projekt.Maps.Platform;
import Projekt.Projekt.Operation.GameModel;
import Projekt.Projekt.Operation.Timer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Projekt.Operation.Constants.S_WIDTH;

public class Level1 extends GameState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;
    private Platform plat1;
    private Platform plat2;
    private Player player;
    private Timer time;

    public Level1(GameModel model) {
        super(model);
        informationText = "Press Escape To Return To The Menu";
        bgColor = new Color(154, 154, 154);
        fontColor = new Color(123, 178, 116);
        this.plat1 = new Platform(100, 400);
        this.plat2 = new Platform(S_WIDTH - 200, 400);
        this.player = new Player();
        this.time = new Timer();
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
        drawBg(g, bgColor);

        //g.drawString(informationText, (S_WIDTH / 2) - 200, S_HEIGHT / 2);

        plat1.draw(g);
        plat2.draw(g);

        player.draw(g);

        time.draw(g);

        for (Enemy enemy : enemies) {
            enemy.draw(g);
        }

        for (Beam beam : beamList) {
            beam.draw(g);
        }
    }

    @Override
    public void keyPressed(int key, GameModel model) {
        System.out.println("Trycker på " + KeyEvent.getKeyText(key) + " i PlayState");

        if (key == KeyEvent.VK_ESCAPE) {
            model.switchState(new MenuState(model));
        } else {
            player.keyPressed(key, model);
        }
    }


    @Override
    public void update(GameModel model, ArrayList<Enemy> enemyList, ArrayList<Beam> beamList) {
        model.addEnemy(player.getY());

        for (int i = 0; i < enemyList.size(); i++) {
            Enemy enemy = enemyList.get(i);
            if (enemy.getRemove() == false) {
                enemy.update(model);
            } else {
                enemyList.remove(i);
            }
        }

        for (int i = 0; i < beamList.size(); i++) {
            Beam beam = beamList.get(i);
            if (beam.getRemove() == false) {
                beam.update();
            } else {
                beamList.remove(i);
            }
        }

        model.checkCollision(player);

        player.update();

        time.update();
    }
}

