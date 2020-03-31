package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Characters.Player;
import Projekt.Operation.GameModel;
import Projekt.Operation.Timer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Operation.Constants.S_WIDTH;

public class Level2 extends PlayState {

    private String informationText;
    private Color bgColor;
    private Color fontColor;
    private Player player;
    private Timer time;

    public Level2(GameModel model) {
        super(model);
        informationText = "Press Escape To Return To The Menu";
        bgColor = new Color(154, 154, 154);
        fontColor = new Color(123, 178, 116);
        model.addPlat(new Platform(0, S_HEIGHT - 50, S_WIDTH, 100));
        model.addPlat(new Platform(100, 250, 100, 10));
        model.addPlat(new Platform(S_WIDTH - 200, 250, 100, 10));
        model.addPlat(new Platform((S_WIDTH / 2) - 50, 400, 100, 10));
        this.player = new Player();
        this.time = new Timer();
    }

    @Override
    public void update(GameModel model, ArrayList<Enemy> enemies, ArrayList<Beam> beamList) {
        model.addEnemy(player.getY());

        model.removeEnemy();
        model.removeBeam();

        player.update();

        model.checkCollision(player);

        time.update();
    }

    @Override
    public void draw(Graphics g, ArrayList<Enemy> enemies, ArrayList<Beam> beamList, ArrayList<Platform> platList) {
        drawBg(g, bgColor);

        player.draw(g);

        time.draw(g);

        for (Platform platform : platList) {
            platform.draw(g);
        }

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
}
