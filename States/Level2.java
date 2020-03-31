package Projekt.States;

import Projekt.Characters.Beam;
import Projekt.Characters.Enemy;
import Projekt.Characters.Platform;
import Projekt.Characters.Player;
import Projekt.Operation.GameModel;
import Projekt.Operation.Timer;
import Projekt.PowerUps.Mushroom;
import Projekt.PowerUps.PowerUp;
import Projekt.PowerUps.Star;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static Projekt.Operation.Constants.S_HEIGHT;
import static Projekt.Operation.Constants.S_WIDTH;

public class Level2 extends PlayState {

    public Level2(GameModel model) {
        super(model);
        model.addPlat(new Platform(0, S_HEIGHT - 50, S_WIDTH, 100));
        model.addPlat(new Platform(100, 250, 100, 10));
        model.addPlat(new Platform(S_WIDTH - 200, 250, 100, 10));
        model.addPlat(new Platform((S_WIDTH / 2) - 50, 400, 100, 10));
        model.addPower(new Star(135,200));
        model.addPower(new Mushroom(S_WIDTH-165,200));
    }
}
