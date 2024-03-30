package game;

import Map.Grid;
import entity.Player;
import entity.consumable.Consumable;
import entity.consumable.PoisonedApple;
import org.w3c.dom.ls.LSOutput;

public class Game {
    public static final int DEFAUT_DISEASE_LEVEL = 1;
    public static final int DEFAULT_ENERGY_RECOVER_DURATION = 5000;
    public static final int DEFAULT_PLAYER_ENERGY = 100;
    public static final int DEFAULT_PLAYER_INVICIBILITY_DURATION = 4000;
    public static final int DEFAULT_NB_LIVES = 5;



    private int diseaseLevel = 1;
    private int energyRecoverDuration;
    private int playerEnergy;
    private int playerInvincibilityDuration;
    private int nbLives;





    private static Grid grid = new Grid();
    private static Player player = new Player(DEFAUT_DISEASE_LEVEL,
            DEFAULT_ENERGY_RECOVER_DURATION, DEFAULT_PLAYER_ENERGY, DEFAULT_PLAYER_INVICIBILITY_DURATION,
            DEFAULT_NB_LIVES, 0);
    private static Consumable poisonedApple = new PoisonedApple();

    public static void main(String[] args) {
        System.out.println(grid.toString());
        poisonedApple.applyEffect(player);

    }
}
