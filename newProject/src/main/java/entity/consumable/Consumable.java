package entity.consumable;

import entity.Entity;
import entity.Player;

public abstract class Consumable extends Entity {
    public abstract void applyEffect(Player player);
}
