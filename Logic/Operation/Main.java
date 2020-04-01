package Projekt.Logic.Operation;

/**
 * I main hittar vi den stora spellopen som evigt snurrar, eller tills man stänger ner självaste fönstret.
 * GameFrame och GameModel skapas i relation til varandra och .update, .repaint är de ända funktionerna vi ser utförda
 * , annat än tidshanteringen i spelet. Modellen ser till att rätt State uppdateras, och GameFrame kommer alltid att
 * ritas om för varje "tick", även om bilden är statisk.
 */

import java.awt.*;
import java.io.IOException;

import static Projekt.Logic.Operation.Constants.ms;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        GameModel model = new GameModel();
        GameFrame frame = new GameFrame(model);

        while (true) {

            long lastTime = System.currentTimeMillis();

            model.update();
            frame.repaint();

            long timer = System.currentTimeMillis() - lastTime;

            Toolkit.getDefaultToolkit().sync();

            try {
                Thread.sleep((long) Math.max(ms - timer, 0));
            } catch (InterruptedException e) {
                System.out.println(ms - timer);
            }
        }
    }
}

