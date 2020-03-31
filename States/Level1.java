package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Player;
import Projekt.Characters.Platform;
import Projekt.Operation.GameModel;
import Projekt.Operation.Timer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Operation.Constants.S_WIDTH;

public class Level1 extends GameState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;
    private  Platform plat0;
    private Platform plat1;
    private Platform plat2;
    private Player player;
    private Timer time;

    public Level1(GameModel model) {
        super(model);
        informationText = "Press Escape To Return To The Menu";
        bgColor = new Color(154, 154, 154);
        fontColor = new Color(123, 178, 116);
        this.plat0 = new Platform(0,S_HEIGHT-50,S_WIDTH,100);
        model.addPlat(plat0);
        this.plat1 = new Platform(100, 400, 100,10);
        model.addPlat(plat1);
        this.plat2 = new Platform(S_WIDTH - 200, 400,100,10);
        model.addPlat(plat2);
        this.player = new Player();
        this.time = new Timer();
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
        drawBg(g, bgColor);

        plat0.draw(g);
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

        if (key == KeyEvent.VK_ESCAPE) {
            model.switchState(new MenuState(model));
        } else {
            player.keyPressed(key, model);
        }
    }


    @Override
    public void update(GameModel model, ArrayList<Enemy> enemyList, ArrayList<Beam> beamList) {
        model.addEnemy(player.getY());

        model.removeEnemy();
        model.removeBeam();

        player.update();

        model.checkCollision(player);

        time.update();
    }
}

