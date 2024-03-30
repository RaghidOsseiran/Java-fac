package entity.consumable;

import entity.Player;
import entity.consumable.Consumable;

import static game.Game.*;

public class Apple extends Consumable {
    private int energyBoost = 5;
    @Override
    public void applyEffect(Player player) {
        player.setDiseaseLevel(DEFAUT_DISEASE_LEVEL);
        player.setPlayerEnergy(player.getPlayerEnergy()+energyBoost);
    }
}
