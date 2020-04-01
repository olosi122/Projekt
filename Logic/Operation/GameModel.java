package Projekt.Logic.Operation;

/**
 * Gamemodel är en av de sörsta och mest omfattande skripten, tillsammans med Player. Det görs en Gamemodel i
 * samband med att spelet skapas i Main. Denna refereras till och används i allt ifrån GameFrame till de djupare
 * underklasserna. Här sparas mycker av den kontinuerliga funktionen som under spelets gång (i lever 1 och level 2)
 * får göra många beräkningar på kollisioner.
 *
 * Den mest unika dela av klassen är att hålla reda på vilket state spelet befinner sig i genom att spara en instans
 * i klassvariablen currentState. Denna uppdateras genom att rätt knapptryck i rätt state skickar in en ny instans
 * av valfritt State genom funktionen switchState.
 *
 * Allt detta resulterar i att .update som körs i den "stora spellopen" i Main endast updaterar det State som man
 * så att säga befinner sig i just nu.
 */

import Projekt.Graphics.Characters.Beam;
import Projekt.Graphics.Characters.Enemy;
import Projekt.Graphics.Characters.Player;
import Projekt.Graphics.Characters.Platform;
import Projekt.Graphics.PowerUps.PowerUp;
import Projekt.Logic.States.GameState;
import Projekt.Logic.States.MenuState;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class GameModel {

    private GameState currentState;
    private ArrayList<Enemy> enemyList = new ArrayList<>();
    private ArrayList<Beam> beamList = new ArrayList<>();
    private ArrayList<Platform> platList = new ArrayList<>();
    private ArrayList<PowerUp> powerList = new ArrayList<>();


    public GameModel() throws IOException {
        this.currentState = new MenuState(this);
    }

    public void switchState(GameState nextState) {
        currentState = nextState;
    }

    public void addPlat(Platform platform) {
        this.platList.add(platform);
    }

    public void addPower(PowerUp power) {
        this.powerList.add(power);
    }

    public void keyPressed(int key) throws IOException, ClassNotFoundException {
        currentState.keyPressed(key, this);
    }

    public void update() throws IOException, ClassNotFoundException {
        currentState.update(this, enemyList, beamList);
    }

    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }

    public void removeEnemy() {
        for (int i = 0; i < enemyList.size(); i++) {
            Enemy enemy = enemyList.get(i);
            if (enemy.getRemove() == false) {
                enemy.update(this);
            } else {
                enemyList.remove(i);
            }
        }
    }

    public void removeBeam() {
        for (int i = 0; i < beamList.size(); i++) {
            Beam beam = beamList.get(i);
            if (beam.getRemove() == false) {
                beam.update();
            } else {
                beamList.remove(i);
            }
        }
    }

    public void clearLevel() {
        this.enemyList = new ArrayList<>();
        this.beamList = new ArrayList<>();
        this.platList = new ArrayList<>();
        this.powerList = new ArrayList<>();
    }

    public void removePower() {
        for (int i = 0; i < powerList.size(); i++) {
            PowerUp power = powerList.get(i);
            if (power.getRemove() == true) {
                powerList.remove(i);
            }
        }
    }

    public void fire(Player player) {
        this.beamList.add(new Beam(player.getX(), player.getY()+25, player.getDir())); //Skicka med model i beam för att ta bort
    }

    public void draw(Graphics g) throws IOException, ClassNotFoundException {
        currentState.draw(g, enemyList, beamList, platList, powerList);
    }

    public void checkCollision(Player player) throws IOException, ClassNotFoundException {
        Rectangle p = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());

        for (Enemy enemy : enemyList) {
            Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
            if (rec2.intersects(p) && player.getActiveMushroom()==true) {
                player.setActiveMushroom(false);
                player.setActiveStar(true);
            }
            if (rec2.intersects(p) && player.getActiveStar()==false) {
                currentState.getTime();
                clearLevel();
                switchState(new MenuState(this));
            }
        }

        for (PowerUp power : powerList) {
            Rectangle rec5 = new Rectangle(power.getX(), power.getY(), power.getWidth(), power.getHeight());
            if (rec5.intersects(p)) {
                power.activate();
                power.setRemove(true);
            }
        }

        for (Beam beam : beamList) {
            Rectangle rec1 = new Rectangle(beam.getX(), beam.getY(), beam.getWidth(), beam.getHeight());
            for (Enemy enemy : enemyList) {
                Rectangle rec2 = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                if (rec1.intersects(rec2)) {
                    beam.setRemove(true);
                    enemy.setRemove(true);
                }
            }
        }

        for (Platform platform : platList) {
            Rectangle rec4 = new Rectangle(platform.getX(), platform.getY(), platform.getWidth(), platform.getHeight());
            if (rec4.intersects(p)) {
                player.setGround(true);
                player.setGroundLevel(platform.getY() - player.getHeight());
                return;
            }
        }
        player.setGround(false);
    }
}


