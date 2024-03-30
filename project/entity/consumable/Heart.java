package entity.consumable;

import entity.Player;
import entity.consumable.Consumable;

public class Heart extends Consumable {

    @Override
    public void applyEffect(Player player) {
        player.setNbLives(player.getNbLives()+1);
    }
}
